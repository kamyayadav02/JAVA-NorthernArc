package org.northernarc.ecommerce.repository;

import org.northernarc.ecommerce.model.Customer;
import org.northernarc.ecommerce.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem,Integer> {
    public List<OrderItem> findByOrderId(int orderid);
}
