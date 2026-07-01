package org.northernarc.productrental.service;

import org.northernarc.productrental.dto.DashboardMetricsDTO;
import org.northernarc.productrental.entity.RentalRecord;

import java.util.List;

public interface RentalService {
    List<RentalRecord> getAllRentals();
    RentalRecord getRentalById(Long rentalId);
    DashboardMetricsDTO getDashboard();


}
