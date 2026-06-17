package com.northernArc.thirdbootapp.dao;

import com.northernArc.thirdbootapp.model.Flight;

import java.util.Map;

public interface FlightDao {
    public void save(Flight flight);
    public Flight findByFlightNum(String flightNum);
    public void deleteByFlightNum(String flightNum);
    void updateByFlightNum(String flightNum,Flight flight);
    public Map<String,Flight> findAll();

}
