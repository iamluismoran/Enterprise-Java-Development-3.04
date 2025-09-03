package com.example.demo.repository;

import com.example.demo.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
public class FlightRepositoryTest {

    @Autowired
    private FlightRepository flightRepository;

    @BeforeEach
    void setUp() {
        flightRepository.deleteAll();
        flightRepository.save(new Flight("AA100", "Boeing 737-800", 160, 350));
        flightRepository.save(new Flight("UA200", "Boeing 787-9", 280, 5_200));
        flightRepository.save(new Flight("DL300", "Airbus A320", 150, 480));
        flightRepository.save(new Flight("IB400", "Airbus A350-900", 300, 4_200));
    }

    @Test
    void canCreateNewFlights() {
        Flight saved = flightRepository.save(new Flight("LA500", "Boeing 767-300", 250, 6_800));
        assertNotNull(saved.getFlightId());
        assertEquals("LA500", saved.getFlightId());
    }

    @Test
    void findFlightByFlightNumber() {
        assertTrue(flightRepository.findByFlightNumber("AA100").isPresent());
        assertEquals("Boeing 737-800",
                flightRepository.findByFlightNumber("AA100").get().getAircraft());
    }

    @Test
    void findAircraftContainingBoeing() {
        List<Flight> boeings = flightRepository.findByAircraftContainingIgnoreCase("Boeing");
        assertEquals(2, boeings.size());
        assertTrue(boeings.stream().allMatch(f -> f.getAircraft().toLowerCase().contains("boeing")));
    }

    @Test
    void findFlightsWithDistanceGreaterThan500Miles() {
        List<Flight> longHauls = flightRepository.findByMileageGreaterThan(500);
        assertFalse(longHauls.isEmpty());
        assertTrue(longHauls.stream().allMatch(f -> f.getFlightMileage() > 500));

    }
}
