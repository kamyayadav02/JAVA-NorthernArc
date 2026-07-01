package org.northernarc.springdatajpademo2.controller;

import org.northernarc.springdatajpademo2.dto.CustomerResponseDTO;
import org.northernarc.springdatajpademo2.model.Customer;
import org.northernarc.springdatajpademo2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/page/{page}/{size}")
    public List<CustomerResponseDTO> getAllCustomers(@PathVariable int page, @PathVariable int size) {
        return customerService.getAllCustomers(page, size);
    }



    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.deleteById(id);
        return "Customer deleted successfully";
    }


    @GetMapping("/name/{name}")
    public Customer getCustomerByName(@PathVariable String name) {
        return customerService.getCustomerByName(name);
    }


}
