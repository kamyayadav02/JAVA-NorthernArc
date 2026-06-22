package org.northernarc.springdatajpademo1.service;

import org.northernarc.springdatajpademo1.exceptions.CustomerNotFound;
import org.northernarc.springdatajpademo1.model.Customer;
import org.northernarc.springdatajpademo1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteById(Long cid) {
        customerRepository.deleteById(cid);
    }
    public Customer getCustomerByName(String name) {
        return customerRepository.findByName(name)
                .orElseThrow(() -> new CustomerNotFound("Customer not found with name: " + name));
    }

}
