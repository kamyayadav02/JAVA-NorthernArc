package org.northernarc.springdatajpademo1.controller;

import org.northernarc.springdatajpademo1.model.OrderItem;
import org.northernarc.springdatajpademo1.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {
    @Autowired
    OrderItemService orderItemService;


    @PostMapping
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.addOrderItem(orderItem);
    }


    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }


    @DeleteMapping("/{oid}")
    public String deleteOrderItem(@PathVariable Long oid) {
        orderItemService.deleteById(oid);
        return "OrderItem deleted successfully";
    }

}
