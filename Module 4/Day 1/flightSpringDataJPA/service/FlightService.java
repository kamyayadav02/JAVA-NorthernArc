package org.northernarc.springdatajpademo2.service;

import org.northernarc.springdatajpademo2.exceptions.FlightNotFound;
import org.northernarc.springdatajpademo2.model.Flight;
import org.northernarc.springdatajpademo2.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;


    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }


    public Flight getFlightById(Integer id) {
        return flightRepository.findById(id)
                .orElseThrow(() -> new FlightNotFound("Flight not found with id: " + id));
    }

    public void deleteById(Integer id) {
        flightRepository.deleteById(id);
    }
    public List<Flight> getByRoute(String source, String destination) {
        List<Flight> flights = flightRepository.findBySourceAndDestination(source, destination);

        if (flights.isEmpty()) {
            throw new RuntimeException("No flights found from " + source + " to " + destination);
        }

        return flights;
    }


}
