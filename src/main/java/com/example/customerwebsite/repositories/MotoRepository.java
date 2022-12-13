package com.example.customerwebsite.repositories;

import com.example.customerwebsite.model.RentalMoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotoRepository extends JpaRepository<RentalMoto, Long> {

    RentalMoto findByCustomerId(Long customerId);
}
