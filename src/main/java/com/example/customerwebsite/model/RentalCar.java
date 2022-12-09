package com.example.customerwebsite.model;

import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
@Builder
@Getter
@Setter
public class RentalCar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String color;
    private String make;
    private Integer model;
    private String license;

    // One to one relationship between the rental car and the customer
    // the JOIN annotation sets up a join column in the rental car table with the customer_id name
    // that will map to the name of any given customer that is associated to a rental car.
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Override
    public String toString() {
        return "RentalCar{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", make='" + make + '\'' +
                ", model=" + model +
                ", license='" + license + '\'' +
                ", customer=" + customer +
                '}';
    }
}
