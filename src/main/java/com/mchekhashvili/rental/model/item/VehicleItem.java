package com.mchekhashvili.rental.model.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicle_items")
@Getter
@Setter
@NoArgsConstructor
public class VehicleItem extends RentalItem {

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer yearOfManufacture;

}