package com.mchekhashvili.rental.model.rental;

import com.mchekhashvili.rental.enums.MileageUnit;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "vehicle_rentals")
@Getter
@Setter
@NoArgsConstructor
public class VehicleRental extends Rental {

    @Column(nullable = false)
    private BigDecimal mileageAtRental;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MileageUnit mileageUnit = MileageUnit.KM;
}