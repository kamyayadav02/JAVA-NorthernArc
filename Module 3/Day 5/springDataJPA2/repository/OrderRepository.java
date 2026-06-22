package org.northernarc.springdatajpademo1.repository;

import org.northernarc.springdatajpademo1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOid(int oid);
}
