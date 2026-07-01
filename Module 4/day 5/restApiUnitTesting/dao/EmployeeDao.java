package org.northernarc.restapiforunittesting.dao;

import org.northernarc.restapiforunittesting.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee save(Employee employee);
    Employee findById(int id);

    Employee findById(Integer id);

    void deleteById(int id);
    void updateById(int id, Employee employee);
    List<Employee> findAll();
}
