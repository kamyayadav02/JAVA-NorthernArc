package org.northernarc.ecommerce.service;

import org.northernarc.ecommerce.DTO.OrderRequestDTO;
import org.northernarc.ecommerce.DTO.OrderResponseDTO;
import org.northernarc.ecommerce.DTO.OrderUpdateDTO;

import java.util.List;

public interface OrderService {

    OrderResponseDTO placeOrder(OrderRequestDTO request);

    List<OrderResponseDTO> getAllOrders();

    OrderResponseDTO getOrderById(Integer id);

    void cancelOrder(Integer orderId);

    List<OrderResponseDTO> getOrdersByCustomer(Integer customerId);

    OrderResponseDTO updateOrder(Integer id,
                                 OrderUpdateDTO dto);
}