package org.northernarc.ecommerce.service;


import org.northernarc.ecommerce.DTO.CustomerRequestDTO;
import org.northernarc.ecommerce.DTO.CustomerResponseDTO;
import org.northernarc.ecommerce.DTO.CustomerUpdateDTO;
import org.northernarc.ecommerce.model.Order;

import java.util.List;

public interface CustomerService {

    CustomerResponseDTO saveCustomer(CustomerRequestDTO customerDTO);

    List<CustomerResponseDTO> getAllCustomers();

    CustomerResponseDTO getCustomerById(Integer id);

    CustomerResponseDTO updateCustomer(Integer id, CustomerUpdateDTO customerDTO);

    void deleteCustomer(Integer id);

    List<Order> getCustomerOrders(Integer customerId);
}
