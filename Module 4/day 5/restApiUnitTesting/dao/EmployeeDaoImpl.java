package org.northernarc.restapiforunittesting.dao;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.northernarc.restapiforunittesting.exception.EmployeeNotFoundException;
import org.northernarc.restapiforunittesting.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
    Map<Integer, Employee> employees;

    @PostConstruct
    public void init() {
        System.out.println("Initializing employee records.");

        employees = new LinkedHashMap<>();

        employees.put(1, new Employee(1, "John Smith", 60000.0));
        employees.put(2, new Employee(2, "Emma Johnson", 75000.0));
        employees.put(3, new Employee(3, "Michael Brown", 55000.0));
        employees.put(4, new Employee(4, "Sophia Davis", 82000.0));
        employees.put(5, new Employee(5, "David Wilson", 68000.0));
    }

    @Override
    public Employee save(Employee employee) {
        employees.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = employees.get(id);

        if (employee == null) {
            throw new EmployeeNotFoundException(
                    "Employee not found with id: " + id);
        }

        return employee;
    }

    @Override
public Employee findById(Integer id) {

        Employee employee = employees.get(id);

        if (employee == null) {
            throw new EmployeeNotFoundException(
                    "Employee not found with id: " + id);
        }

        return employee;
    }


    @Override
    public void deleteById(int id) {
        employees.remove(id);
    }

    @Override
    public void updateById(int id, Employee employee) {
        Employee existingEmployee = employees.get(id);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setSalary(employee.getSalary());
        }
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }
    @PreDestroy
    public void destroy(){
        System.out.println("destroying employees.");
        employees.clear();
    }
}
