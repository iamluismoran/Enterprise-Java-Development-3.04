package com.example.demo.repository;

import com.example.demo.enums.CustomerStatus;
import com.example.demo.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
        customerRepository.save(new Customer("Lucia", CustomerStatus.GOLD,12_000));
        customerRepository.save(new Customer("Elias", CustomerStatus.NONE,1_000));
        customerRepository.save(new Customer("Felix", CustomerStatus.SILVER,45_000));
        customerRepository.save(new Customer("Lucia", CustomerStatus.SILVER,52_000));
    }

    @Test
    void canCreateNewCustomer() {
        Customer saved = customerRepository.save(new Customer("Pamela", CustomerStatus.GOLD, 200_000));
        assertNotNull(saved.getCustomerId());
        assertEquals("Pamela", saved.getCustomerName());
        assertEquals(CustomerStatus.GOLD, saved.getCustomerStatus());
        assertEquals(200_000, saved.getTotalCustomerMileage());
    }

    @Test
    void  findCustomersByName() {
        List<Customer> lucias = customerRepository.findByCustomerName("Lucia");
        assertEquals(2, lucias.size());
        assertTrue(lucias.stream().allMatch(c -> "Lucia".equals(c.getCustomerName())));
    }

    @Test
    void findCustomerByStatus() {
        List<Customer> golds = customerRepository.findByCustomerStatus(CustomerStatus.GOLD);
        assertEquals(1, golds.size());
        assertEquals("Lucia", golds.get(0).getCustomerName());
    }
}
