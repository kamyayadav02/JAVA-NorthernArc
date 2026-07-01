package org.northernarc.springdatajpademo2.repository;

import org.northernarc.springdatajpademo2.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findBySourceAndDestination(String source, String destination);
}
