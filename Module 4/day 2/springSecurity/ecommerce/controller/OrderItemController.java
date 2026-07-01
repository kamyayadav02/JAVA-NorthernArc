package org.northernarc.ecommerce.controller;

import jakarta.validation.Valid;
import org.northernarc.ecommerce.DTO.OrderItemRequestDTO;
import org.northernarc.ecommerce.DTO.OrderItemResponseDTO;
import org.northernarc.ecommerce.DTO.OrderItemUpdateDTO;
import org.northernarc.ecommerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ecom/orderitem")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItemResponseDTO>> findAll() {

        return ResponseEntity.ok(
                orderItemService.getAllOrderItems()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemResponseDTO> findById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                orderItemService.getOrderItemById(id)
        );
    }

    @PostMapping
    public ResponseEntity<OrderItemResponseDTO> save(
            @Valid @RequestBody OrderItemRequestDTO dto) {

        return ResponseEntity.status(201)
                .body(orderItemService.saveOrderItem(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderItemResponseDTO> update(
            @PathVariable Integer id,
            @Valid @RequestBody OrderItemUpdateDTO dto) {

        return ResponseEntity.ok(
                orderItemService.updateOrderItem(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Integer id) {

        orderItemService.deleteOrderItem(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<List<OrderItemResponseDTO>>
    getItemsByOrder(@PathVariable Integer id) {

        return ResponseEntity.ok(
                orderItemService.getItemsByOrder(id)
        );
    }

}