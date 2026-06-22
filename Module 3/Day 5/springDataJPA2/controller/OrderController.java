package org.northernarc.springdatajpademo1.controller;

import org.northernarc.springdatajpademo1.model.Order;
import org.northernarc.springdatajpademo1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderService orderService;


    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }


    @DeleteMapping("/{oid}")
    public String deleteOrder(@PathVariable Long oid) {
        orderService.deleteById(oid);
        return "Order deleted successfully";
    }


}
