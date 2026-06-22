package org.northernarc.springdatajpademo2.service;

import org.northernarc.springdatajpademo2.exceptions.CustomerNotFound;
import org.northernarc.springdatajpademo2.exceptions.FlightNotFound;
import org.northernarc.springdatajpademo2.model.Customer;
import org.northernarc.springdatajpademo2.model.Flight;
import org.northernarc.springdatajpademo2.model.Ticket;
import org.northernarc.springdatajpademo2.repository.CustomerRepository;
import org.northernarc.springdatajpademo2.repository.FlightRepository;
import org.northernarc.springdatajpademo2.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    FlightRepository flightRepository;

    public Ticket bookTicket(Ticket ticket) {

        int customerId = ticket.getCustomer().getId();
        int flightId = ticket.getFlight().getId();


        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFound("Customer not found with id: " + customerId));

        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new FlightNotFound("Flight not found with id: " + flightId));

        ticket.setCustomer(customer);
        ticket.setFlight(flight);

        return ticketRepository.save(ticket);
    }



    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Integer id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found with id: " + id));
    }

    public void deleteById(Integer id) {
        ticketRepository.deleteById(id);
    }

}
