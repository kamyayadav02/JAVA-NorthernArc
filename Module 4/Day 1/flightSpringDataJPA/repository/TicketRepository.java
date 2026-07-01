package org.northernarc.springdatajpademo2.repository;

import org.northernarc.springdatajpademo2.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByCustomerId(Integer customerId);
    List<Ticket> findByFlightId(Integer flightId);
    List<Ticket> findBySeatnum(int seatnum);
    List<Ticket> findByPrice(double price);


}
