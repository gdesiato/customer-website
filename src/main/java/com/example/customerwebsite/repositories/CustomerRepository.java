package com.example.customerwebsite.repositories;

import com.example.customerwebsite.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}