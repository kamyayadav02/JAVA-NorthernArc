package org.northernarc.springdatajpademo.service;

import org.northernarc.springdatajpademo.model.Employee;
import org.northernarc.springdatajpademo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}