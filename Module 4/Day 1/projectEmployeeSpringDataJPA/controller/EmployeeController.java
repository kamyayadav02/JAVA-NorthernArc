package org.northernarc.springdatajpademo.controller;

import org.northernarc.springdatajpademo.dto.EmployeeRequestDTO;
import org.northernarc.springdatajpademo.dto.EmployeeResponseDTO;
import org.northernarc.springdatajpademo.model.Employee;
import org.northernarc.springdatajpademo.model.Project;
import org.northernarc.springdatajpademo.repository.EmployeeRepository;
import org.northernarc.springdatajpademo.service.EmployeeService;
import org.northernarc.springdatajpademo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

//    @GetMapping("/employeeswithdept")
//    public List<Employee> getEmployeesWithDept() {
//        return employeeService.getEmployeesWithDepartment();
//    }

//    @GetMapping("/page/{page}/{size}")
//    public List<EmployeeResponseDTO> getAllEmployees(
//            @PathVariable int page,
//            @PathVariable int size) {
//
//        return employeeService.getAllEmployees(page, size);
//    }

//    @PostMapping
//    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
//        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
//    }

    // using  Request DTO
    @PostMapping
    public Employee add(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return employeeService.saveEmployee(employeeRequestDTO);
    }

    @PutMapping("/update/{name}/{email}")
    public int updateEmployeeEmailByName(@PathVariable String name,@PathVariable String email){
        return employeeService.updateEmployeeEmail(name,email);
//    public ResponseEntity<String> updateEmployeeEmailByName(@PathVariable String name, @PathVariable String email) {
//
//        int updated = employeeService.updateEmployeeEmail(name, email);
//
//        if (updated > 0) {
//            return ResponseEntity.ok("Email updated successfully");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("Employee not found");
//        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
