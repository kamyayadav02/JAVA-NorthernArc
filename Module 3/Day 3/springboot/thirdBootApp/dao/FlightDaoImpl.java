package com.northernArc.thirdbootapp.dao;

import com.northernArc.thirdbootapp.model.Flight;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
@Service
public class FlightDaoImpl implements FlightDao{

    Map<String,Flight> flights;

    @PostConstruct
    public void init(){
        System.out.println("Initialising rows.");
        flights=new HashMap<>();


        flights.put("AI101", new Flight("AI101", "Chennai", "Delhi",
                Date.valueOf("2024-06-20"), Date.valueOf("2024-06-20"),
                Time.valueOf("10:00:00"), Time.valueOf("12:30:00"),
                5000, 120));

        flights.put("AI202", new Flight("AI202", "Mumbai", "Bangalore",
                Date.valueOf("2024-06-21"), Date.valueOf("2024-06-21"),
                Time.valueOf("14:00:00"), Time.valueOf("15:30:00"),
                4500, 100));

        flights.put("AI303", new Flight("AI303", "Hyderabad", "Kolkata",
                Date.valueOf("2024-06-22"), Date.valueOf("2024-06-22"),
                Time.valueOf("09:00:00"), Time.valueOf("11:30:00"),
                4800, 90));

        flights.put("AI404", new Flight("AI404", "Delhi", "Chennai",
                Date.valueOf("2024-06-23"), Date.valueOf("2024-06-23"),
                Time.valueOf("16:00:00"), Time.valueOf("18:45:00"),
                5200, 110));

        flights.put("AI505", new Flight("AI505", "Bangalore", "Mumbai",
                Date.valueOf("2024-06-24"), Date.valueOf("2024-06-24"),
                Time.valueOf("08:30:00"), Time.valueOf("10:00:00"),
                4300, 95));


    }

    @Override
    public void save(Flight flight) {
        flights.put(flight.getFlightNum(), flight);
    }

    @Override
    public Flight findByFlightNum(String flightNum) {
        return flights.get(flightNum);
    }

    @Override
    public void deleteByFlightNum(String flightNum) {
        flights.remove(flightNum);

    }

    @Override
    public void updateByFlightNum(String flightNum, Flight flight) {
        Flight flight1=flights.get(flightNum);
        flight1.setSource(flight.getSource());
        flight1.setDestination(flight.getDestination());
        flight1.setDod(flight.getDod());
        flight1.setDoa(flight.getDoa());
        flight1.setTod(flight.getTod());
        flight1.setToa(flight.getToa());
        flight1.setCostPerSeat(flight.getCostPerSeat());
        flight1.setNumOfSeat(flight.getNumOfSeat());

    }


    @Override
    public Map<String, Flight> findAll() {
        return flights;
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroying flights.");
        flights.clear();
    }

}
