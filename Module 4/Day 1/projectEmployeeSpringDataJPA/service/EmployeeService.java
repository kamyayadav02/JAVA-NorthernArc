package org.northernarc.springdatajpademo.service;

import jakarta.transaction.Transactional;
import org.northernarc.springdatajpademo.dto.EmployeeRequestDTO;
import org.northernarc.springdatajpademo.dto.EmployeeResponseDTO;
import org.northernarc.springdatajpademo.model.Employee;
import org.northernarc.springdatajpademo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

//    public Employee addEmployee(Employee employee) {
//        return employeeRepository.save(employee);
//    }

    public Employee saveEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new Employee();
        employee.setName(employeeRequestDTO.getName());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setDept(employeeRequestDTO.getDept());
        return employee;
//        return employeeRepository.save(employee);
    }
    
    public EmployeeResponseDTO add(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee=mapToEntity(employeeRequestDTO);
        Employee savedEmp=employeeRepository.save(employee);
        return mapToResponseDTO(savedEmp);
    }

    private EmployeeResponseDTO mapToResponseDTO(Employee savedEmp) {

        return new EmployeeResponseDTO(
                savedEmp.getId(),
                savedEmp.getName(),
                savedEmp.getEmail(),
                savedEmp.getDept()
        );
    }

    private Employee mapToEntity(EmployeeRequestDTO employeeRequestDTO) {
            Employee employee = new Employee();
            employee.setName(employeeRequestDTO.getName());
            employee.setEmail(employeeRequestDTO.getEmail());
            return employee;
    }

    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(emp -> new EmployeeResponseDTO(
                        emp.getId(),
                        emp.getName(),
                        emp.getDept(),
                        emp.getEmail()
                ))
                .toList();
    }

//
//    public List<Employee> getEmployeesWithDepartment() {
//        return employeeRepository.getEmployeesWithDepartment();
//    }


    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
//    public EmployeeResponseDTO updateEmployee(EmployeeUpdateDTO dto) {
//
//        Employee employee = employeeRepository.findById(dto.getId())
//                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + dto.getId()));
//
//        employee.setName(dto.getName());
//        employee.setDept(dto.getDepartment());
//        employee.setEmail(dto.getEmail());
//
//        Employee updatedEmp = employeeRepository.save(employee);
//
//        return mapToResponseDTO(updatedEmp);
//    }

    @Transactional
    public int updateEmployeeEmail(String name, String email) {
        return employeeRepository.updateEmployeeEmailByName(name, email);
    }

}