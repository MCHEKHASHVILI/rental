package com.mchekhashvili.rental.model.customer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "individual_customers")
@Getter
@Setter
@NoArgsConstructor
public class IndividualCustomer extends Customer {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
}