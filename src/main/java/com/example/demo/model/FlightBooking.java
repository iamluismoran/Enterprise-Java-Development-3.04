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

    // Relaciones solamente para que Hibernate genere las foreign keys en el DDL.
    // y para poder navegar a las entidades relacionadas.
    // Los Integer siguen siendo los dueños de los valores (insert/update).
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "customerId",
            referencedColumnName = "customerId",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "fk_flight_booking_customer")
    )
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "flightId",
            referencedColumnName = "flightId",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(name = "fk_flight_booking_flight")
    )
    private Flight flight;
}
