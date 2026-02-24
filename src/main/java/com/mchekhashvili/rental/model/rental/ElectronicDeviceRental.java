package com.mchekhashvili.rental.model.rental;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "electronic_device_rentals")
@Getter
@Setter
@NoArgsConstructor
public class ElectronicDeviceRental extends Rental {

    @Column(nullable = false)
    private boolean isDamaged;

    @Column
    private String damageDescription;
}