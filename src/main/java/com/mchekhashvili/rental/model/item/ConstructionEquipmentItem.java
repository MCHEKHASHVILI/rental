package com.mchekhashvili.rental.model.item;

import com.mchekhashvili.rental.enums.EquipmentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "construction_equipment_items")
@Getter
@Setter
@NoArgsConstructor
public class ConstructionEquipmentItem extends RentalItem {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EquipmentType equipmentType;

    @Column(nullable = false)
    private String manufacturer;

}