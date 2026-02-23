package com.mchekhashvili.rental.model.item;

import com.mchekhashvili.rental.enums.DeviceCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "electronic_device_items")
@Getter
@Setter
@NoArgsConstructor
public class ElectronicDeviceItem extends RentalItem {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceCategory category;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false, unique = true)
    private String serialNumber;

}