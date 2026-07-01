package org.northernarc.restapiforunittesting;

import org.junit.jupiter.api.Test;
import org.northernarc.restapiforunittesting.controller.EmployeeController;
import org.northernarc.restapiforunittesting.exception.EmployeeNotFoundException;
import org.northernarc.restapiforunittesting.exception.GlobalExceptionHandler;
import org.northernarc.restapiforunittesting.model.Employee;
import org.northernarc.restapiforunittesting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class) //to show we are doing webmvc for controller
@Import(GlobalExceptionHandler.class)
public class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockitoBean  //mockBean mockitobean same thing, if we don't do this we will have to do @mock and injectmock
    EmployeeService service;

    @Test
    void testgetEmployeeSuccess() throws Exception{
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John Smith");
        employee.setSalary(60000.0);
        when(service.get(1)).thenReturn(employee);
        mockMvc.perform(get("/api/emp/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("John Smith"))
                .andExpect(jsonPath("$.salary").value(60000.0));
    }

    @Test
    void testgetEmployeeNotFound() throws Exception {
//stub
        when(service.get(8)).thenThrow(new EmployeeNotFoundException("Employee not found with id: 8"));

        mockMvc.perform(get("/api/emp/8"))
                .andExpect(status().isNotFound())  //404 error
                .andExpect(content().string("Employee not found with id: 8"));
    }

    @Test
    void testDeleteEmployeeSuccess() throws Exception {
        doNothing().when(service).delete(1);// there is no need for stub here but we can put if we want
        mockMvc.perform(delete("/api/emp/1"))
                .andExpect(status().isNoContent());
    }


    @Test
    void testAddEmployeeSuccess() throws Exception {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Smith");
        employee.setSalary(200000.0);

        when(service.addEmployee(employee)).thenReturn(employee);

        mockMvc.perform(post("/api/emp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Smith"))
                .andExpect(jsonPath("$.salary").value(200000.0));
    }

    @Test
    void testUpdateEmployeeSuccess() throws Exception {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John Smith");
        employee.setSalary(65000.0);

// no return type we have void, so we don't need to stub it, but we can do it if we want.
        mockMvc.perform(put("/api/emp/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("John Smith"))
                .andExpect(jsonPath("$.salary").value(65000.0));

        verify(service).update(eq(1), any(Employee.class));
    }
}
