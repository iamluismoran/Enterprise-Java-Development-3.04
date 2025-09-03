package com.example.demo.repository;

import com.example.demo.model.Flight;
import com.example.demo.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
}
