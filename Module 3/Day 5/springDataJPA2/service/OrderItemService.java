package org.northernarc.springdatajpademo1.service;

import org.northernarc.springdatajpademo1.model.OrderItem;
import org.northernarc.springdatajpademo1.repository.OrderItemRepository;
import org.northernarc.springdatajpademo1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    public OrderItem addOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public void deleteById(Long id) {
        orderItemRepository.deleteById(id);
    }
}