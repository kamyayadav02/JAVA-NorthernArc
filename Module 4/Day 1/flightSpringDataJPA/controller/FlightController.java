package org.northernarc.springdatajpademo2.controller;

import org.northernarc.springdatajpademo2.model.Flight;
import org.northernarc.springdatajpademo2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Autowired
    FlightService flightService;

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Integer id) {
        return flightService.getFlightById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable Integer id) {
        flightService.deleteById(id);
        return "Flight deleted successfully";
    }

    @GetMapping("/route")
    public List<Flight> getFlightsByRoute(@RequestParam String source,
                                          @RequestParam String destination) {
        return flightService.getByRoute(source, destination);
    }

}
