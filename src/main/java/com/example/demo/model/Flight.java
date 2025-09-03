package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "flights")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flightId")
    private Integer flightId;

    @Column(name = "flightNumber", unique = true, nullable = false)
    private String flightNumber;

    @Column(name = "aircraft", nullable = false)
    private String aircraft;

    @Column(name = "totalAircraftSeats", nullable = false)
    private Integer totalAircraftSeats;

    @Column(name = "flightMileage", nullable = false)
    private Integer flightMileage;

    public Flight(String flightNumber, String aircraft, Integer totalAircraftSeats, Integer flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
    }
}
