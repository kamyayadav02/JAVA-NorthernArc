package org.northernarc.ecommerce.service;


import org.northernarc.ecommerce.DTO.OrderItemRequestDTO;
import org.northernarc.ecommerce.DTO.OrderItemResponseDTO;
import org.northernarc.ecommerce.DTO.OrderItemUpdateDTO;

import java.util.List;

public interface OrderItemService {

    OrderItemResponseDTO saveOrderItem(OrderItemRequestDTO dto);

    List<OrderItemResponseDTO> getAllOrderItems();

    OrderItemResponseDTO getOrderItemById(Integer id);

    OrderItemResponseDTO updateOrderItem(Integer id, OrderItemUpdateDTO dto);

    void deleteOrderItem(Integer id);

    List<OrderItemResponseDTO> getItemsByOrder(Integer orderId);
}