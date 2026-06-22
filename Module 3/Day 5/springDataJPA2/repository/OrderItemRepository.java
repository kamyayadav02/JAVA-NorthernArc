package org.northernarc.springdatajpademo1.repository;

import org.northernarc.springdatajpademo1.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
