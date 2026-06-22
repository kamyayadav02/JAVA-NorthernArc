package org.northernarc.springdatajpademo1.service;

import org.northernarc.springdatajpademo1.model.Order;
import org.northernarc.springdatajpademo1.model.OrderItem;
import org.northernarc.springdatajpademo1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;


    public Order addOrder(Order order) {

        if (order.getOrderItems() != null) {
            for (OrderItem item : order.getOrderItems()) {
                item.setOrder(order);
            }
        }

        return orderRepository.save(order);
    }


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteById(Long oid) {
        orderRepository.deleteById(oid);
    }
}
