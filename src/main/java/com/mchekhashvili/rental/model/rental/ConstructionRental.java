package com.mchekhashvili.rental.model.rental;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "construction_rentals")
@Getter
@Setter
@NoArgsConstructor
public class ConstructionRental extends Rental {

    @Column(nullable = false)
    private String conditionAtRental;

    @Column(nullable = false)
    private boolean requiresLicensedOperator;
}