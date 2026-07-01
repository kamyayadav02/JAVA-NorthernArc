package org.northernarc.springdatajpademo.repository;

import jakarta.transaction.Transactional;
import org.northernarc.springdatajpademo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name);
    Employee findById(long id);
//    @Query("""
//SELECT e FROM Employee e JOIN FETCH e.project
//""")
//    List<Employee> getEmployeesWithDepartment();


    @Modifying
    @Query("""
Update Employee e SET e.email= :email WHERE e.name=:name
""")
    int updateEmployeeEmailByName(@Param("name") String name, @Param("email") String newEmail);
}
