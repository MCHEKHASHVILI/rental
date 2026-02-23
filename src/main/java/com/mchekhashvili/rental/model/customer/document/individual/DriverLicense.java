package com.mchekhashvili.rental.model.customer.document.individual;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "driver_licenses")
@Getter
@Setter
@NoArgsConstructor
public class DriverLicense extends IndividualDocument {

    @Column(nullable = false, length = 50)
    private String licenseCategories;
}