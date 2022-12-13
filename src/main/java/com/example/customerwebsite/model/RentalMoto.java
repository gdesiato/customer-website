package com.example.customerwebsite.model;

        import lombok.*;
        import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "moto")
@Builder
@Getter
@Setter
public class RentalMoto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String color;
    private String make;
    private Integer model;
    private Integer cc;

    // One to one relationship between the rental moto and the customer
    // the JOIN annotation sets up a join column in the rental moto table with the customer_id name
    // that will map to the name of any given customer that is associated to a rental moto.
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Override
    public String toString() {
        return "RentalMoto{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", make='" + make + '\'' +
                ", model=" + model +
                ", license='" + cc + '\'' +
                ", customer=" + customer +
                '}';
    }
}
