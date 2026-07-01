package org.northernarc.restapiforunittesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.northernarc.restapiforunittesting.dao.EmployeeDao;
import org.northernarc.restapiforunittesting.model.Employee;
import org.northernarc.restapiforunittesting.service.EmployeeServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void testGetEmployeeById() {

        Employee employee =
                new Employee(1, "John Smith", 60000.0);

        when(employeeDao.findById(1)).thenReturn(employee);

        Employee result = employeeService.get(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("John Smith", result.getName());

        verify(employeeDao).findById(1);
    }

    @Test
    void testAddEmployee() {

        Employee employee = new Employee(6, "Rahul", 50000.0);

        when(employeeDao.save(employee))
                .thenReturn(employee);

        Employee result =
                employeeService.addEmployee(employee);

        assertEquals(6, result.getId());

        verify(employeeDao).save(employee);
    }

    @Test
    void testDeleteEmployee() {

        employeeService.delete(1);

        verify(employeeDao).deleteById(1);
    }
}