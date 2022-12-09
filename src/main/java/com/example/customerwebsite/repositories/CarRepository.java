package com.example.customerwebsite.repositories;

import com.example.customerwebsite.model.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<RentalCar, Long> {

    RentalCar findCustomerId(Long id);
    RentalCar findByCustomerId(Long customerId);
}
