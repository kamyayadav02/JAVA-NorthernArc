package org.northernarc.restapiforunittesting.service;

import org.northernarc.restapiforunittesting.dao.EmployeeDao;
import org.northernarc.restapiforunittesting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;
    @Override
    public Employee addEmployee(Employee employee) {
        employeeDao.save(employee);
        return employee;
    }

    @Override
    public Employee get(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public void delete(int id) {
        employeeDao.deleteById(id);
    }

    @Override
    public void update(int id, Employee employee) {
        employeeDao.updateById(id,employee);

    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
