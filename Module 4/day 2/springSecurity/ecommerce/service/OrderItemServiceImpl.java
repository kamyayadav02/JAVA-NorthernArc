package org.northernarc.ecommerce.service;

import org.northernarc.ecommerce.DTO.OrderItemRequestDTO;
import org.northernarc.ecommerce.DTO.OrderItemResponseDTO;
import org.northernarc.ecommerce.DTO.OrderItemUpdateDTO;
import org.northernarc.ecommerce.exceptions.OrderNotFound;
import org.northernarc.ecommerce.model.Order;
import org.northernarc.ecommerce.model.OrderItem;
import org.northernarc.ecommerce.model.Product;
import org.northernarc.ecommerce.repository.OrderItemRepo;
import org.northernarc.ecommerce.repository.OrderRepo;
import org.northernarc.ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public OrderItemResponseDTO saveOrderItem(OrderItemRequestDTO dto) {

        Order order = orderRepo.findById(dto.getOrderId())
                .orElseThrow(() ->
                        new OrderNotFound("Order not found"));

        Product product = productRepo.findById(dto.getProductId())
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        OrderItem orderItem = new OrderItem();

        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(dto.getQuantity());

        OrderItem saved = orderItemRepo.save(orderItem);

        return mapToResponse(saved);
    }

    @Override
    public List<OrderItemResponseDTO> getAllOrderItems() {

        return orderItemRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public OrderItemResponseDTO getOrderItemById(Integer id) {

        OrderItem orderItem = orderItemRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("OrderItem not found"));

        return mapToResponse(orderItem);
    }

    @Override
    public OrderItemResponseDTO updateOrderItem(Integer id,
                                                OrderItemUpdateDTO dto) {

        OrderItem orderItem = orderItemRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("OrderItem not found"));

        Order order = orderRepo.findById(dto.getOrderId())
                .orElseThrow(() ->
                        new OrderNotFound("Order not found"));

        Product product = productRepo.findById(dto.getProductId())
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(dto.getQuantity());

        OrderItem updated = orderItemRepo.save(orderItem);

        return mapToResponse(updated);
    }

    @Override
    public void deleteOrderItem(Integer id) {

        orderItemRepo.deleteById(id);
    }

    @Override
    public List<OrderItemResponseDTO> getItemsByOrder(Integer orderId) {

        return orderItemRepo.findByOrderId(orderId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private OrderItemResponseDTO mapToResponse(OrderItem orderItem) {

        OrderItemResponseDTO dto = new OrderItemResponseDTO();

        dto.setId(orderItem.getId());

        dto.setOrderId(orderItem.getOrder().getId());

        dto.setProductId(orderItem.getProduct().getId());

        dto.setProductName(orderItem.getProduct().getName());

        dto.setQuantity(orderItem.getQuantity());

        dto.setProductCost(orderItem.getProduct().getCost());

        dto.setTotalPrice(
                orderItem.getQuantity()
                        * orderItem.getProduct().getCost()
        );

        return dto;
    }
}