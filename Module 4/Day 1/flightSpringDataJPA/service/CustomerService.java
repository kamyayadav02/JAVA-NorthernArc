package org.northernarc.springdatajpademo2.service;

import org.northernarc.springdatajpademo2.dto.CustomerRequestDTO;
import org.northernarc.springdatajpademo2.dto.CustomerResponseDTO;
import org.northernarc.springdatajpademo2.exceptions.CustomerNotFound;
import org.northernarc.springdatajpademo2.model.Customer;
import org.northernarc.springdatajpademo2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

//    public List<Customer> getAllCustomers() {
//        return customerRepository.findAll();
//    }

    public CustomerResponseDTO add(CustomerRequestDTO customerRequestDTO) {
        Customer customer=mapToEntity(customerRequestDTO);
        Customer savedCustomer=customerRepository.save(customer);
        return mapToResponseDTO(savedCustomer);
    }

    private Customer mapToEntity(CustomerRequestDTO customerRequestDTO) {
        Customer customer = new Customer();
        customer.setName(customerRequestDTO.getName());
        customer.setEmail(customerRequestDTO.getEmail());
        customer.setPhoneno(customerRequestDTO.getPhoneno());
        return customer;
    }

    private CustomerResponseDTO mapToResponseDTO(Customer savedCustomer) {
        return new CustomerResponseDTO(
                savedCustomer.getId(),
                savedCustomer.getName()
        );
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

    public List<CustomerResponseDTO> getAllCustomers(int page,int size) {
        List<Customer> customers = customerRepository.findAll(PageRequest.of(page, size)).getContent();

        return customers.stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

}
