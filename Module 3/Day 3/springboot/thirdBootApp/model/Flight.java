package com.northernArc.thirdbootapp.model;

import java.sql.Date;
import java.sql.Time;

public class Flight {
    private String flightNum;
    private String source;
    private String destination;
    private Date dod;
    private Date doa;
    private Time tod;
    private Time toa;
    private int costPerSeat;
    private int numOfSeat;

    public Flight(String flightNum, String source, String destination, Date dod, Date doa, Time tod, Time toa, int costPerSeat, int numOfSeat) {
        this.flightNum = flightNum;
        this.source = source;
        this.destination = destination;
        this.dod = dod;
        this.doa = doa;
        this.tod = tod;
        this.toa = toa;
        this.costPerSeat = costPerSeat;
        this.numOfSeat = numOfSeat;
    }

    public Flight(String source, String destination, Date dod, Date doa, Time tod, Time toa, int costPerSeat, int numOfSeat) {
        this.source = source;
        this.destination = destination;
        this.dod = dod;
        this.doa = doa;
        this.tod = tod;
        this.toa = toa;
        this.costPerSeat = costPerSeat;
        this.numOfSeat = numOfSeat;
    }

    public Flight() {
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNum='" + flightNum + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", dod=" + dod +
                ", doa=" + doa +
                ", tod=" + tod +
                ", toa=" + toa +
                ", costPerSeat=" + costPerSeat +
                ", numOfSeat=" + numOfSeat +
                '}';
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDod() {
        return dod;
    }

    public void setDod(Date dod) {
        this.dod = dod;
    }

    public Date getDoa() {
        return doa;
    }

    public void setDoa(Date doa) {
        this.doa = doa;
    }

    public Time getTod() {
        return tod;
    }

    public void setTod(Time tod) {
        this.tod = tod;
    }

    public Time getToa() {
        return toa;
    }

    public void setToa(Time toa) {
        this.toa = toa;
    }

    public int getCostPerSeat() {
        return costPerSeat;
    }

    public void setCostPerSeat(int costPerSeat) {
        this.costPerSeat = costPerSeat;
    }

    public int getNumOfSeat() {
        return numOfSeat;
    }

    public void setNumOfSeat(int numOfSeat) {
        this.numOfSeat = numOfSeat;
    }
}
