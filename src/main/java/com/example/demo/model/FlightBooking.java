package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flight_bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"customer", "flight"})
@EqualsAndHashCode(of = "bookingId")
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private Integer bookingId;

    @Column(name = "customerId", nullable = false)
    private Integer customerId;

    @Column(name = "flightId", nullable = false)
    private Integer flightId;

    public FlightBooking(Integer customerId, Integer flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

}
