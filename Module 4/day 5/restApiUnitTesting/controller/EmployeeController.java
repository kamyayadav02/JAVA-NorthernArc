package org.northernarc.restapiforunittesting.controller;

import org.northernarc.restapiforunittesting.model.Employee;
import org.northernarc.restapiforunittesting.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id){
        return new ResponseEntity<>(employeeService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {

        employeeService.delete(id);

        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return ResponseEntity.status(201).body(employeeService.addEmployee(employee));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateById(@PathVariable int id, @RequestBody Employee employee){
        employeeService.update(id,employee);
        return ResponseEntity.ok(employee);
    }

}
