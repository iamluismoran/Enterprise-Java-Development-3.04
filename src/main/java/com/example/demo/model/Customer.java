package com.example.demo.model;

import com.example.demo.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Integer customerId;

    @Column(name = "customerName", nullable = false)
    private String customerName;

    @Enumerated(EnumType.STRING)
    @Column(name = "customerStatus", nullable = false)
    private CustomerStatus customerStatus;

    @Column(name = "totalCustomerMileage", nullable = false)
    private Integer totalCustomerMileage;

    public Customer(String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }
}
