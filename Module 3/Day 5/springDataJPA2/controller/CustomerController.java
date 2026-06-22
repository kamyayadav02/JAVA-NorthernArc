package org.northernarc.springdatajpademo1.controller;

import org.northernarc.springdatajpademo1.model.Customer;
import org.northernarc.springdatajpademo1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }


    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping("/{cid}")
    public String deleteCustomer(@PathVariable Long cid) {
        customerService.deleteById(cid);
        return "Customer deleted successfully";
    }
    @GetMapping("/name/{name}")
    public Customer getCustomerByName(@PathVariable String name) {
        return customerService.getCustomerByName(name);
    }

}
