package org.northernarc.restapiforunittesting.service;

import org.northernarc.restapiforunittesting.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee get(int id);
    void delete(int id);
    void update(int id, Employee employee);
    List<Employee> findAll();

}
