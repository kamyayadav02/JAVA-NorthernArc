package org.northernarc.springdatajpademo2.service;

import org.northernarc.springdatajpademo2.exceptions.CustomerNotFound;
import org.northernarc.springdatajpademo2.model.Customer;
import org.northernarc.springdatajpademo2.repository.CustomerRepository;
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

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFound("Customer not found with id: " + id));
    }

    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }


    public Customer getCustomerByName(String name) {
        return customerRepository.findByName(name)
                .orElseThrow(() -> new CustomerNotFound("Customer not found with name: " + name));
    }
}
