package com.example.demo.repository;

import com.example.demo.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContainingIgnoreCase(String keyword);
    List<Flight> findByMileageGreaterThan(Integer miles);
}
