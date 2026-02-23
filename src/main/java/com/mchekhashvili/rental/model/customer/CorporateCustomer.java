package com.mchekhashvili.rental.model.customer;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "corporate_customers")
@Getter
@Setter
@NoArgsConstructor
public class CorporateCustomer extends Customer {

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false, unique = true)
    private String registrationNumber;

    @Column
    private String contactPersonName;
}