package org.northernarc.springdatajpademo.repository;

import org.northernarc.springdatajpademo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name);
}
