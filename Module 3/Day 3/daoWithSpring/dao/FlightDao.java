package dao;

import entity.Flight;

import java.util.Collection;
import java.util.Date;

public interface FlightDao {
    public int save(Flight flight);
    public Flight findByFlightNum(String flightNum);
    public void deleteByFlightNum(String flightNum);
    void updateByFlightNum(String flightNum,Flight flight);
    public void deleteAll();
    public Collection<Flight> findAll();
    public Collection<Flight> findBySourceAndDestinationAndDepartureDate(String source, String destination, Date dod);

}
