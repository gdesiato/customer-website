package com.example.customerwebsite.repositories;

import com.example.customerwebsite.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

// The repository allow us to have all the functionalities, such as finding, saving, updating, etc.
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}