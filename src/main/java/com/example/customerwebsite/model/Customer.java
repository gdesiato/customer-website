package com.example.customerwebsite.model;


import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@Builder
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String email;
    private Integer age;
    private String address;

    // MAPPEDBY means that the Customer is the owning side of this OneToOne relationship
    // and the RentalCar is the non-owning side of this relationship
    @OneToOne (mappedBy = "customer")
    private RentalCar car;
}
