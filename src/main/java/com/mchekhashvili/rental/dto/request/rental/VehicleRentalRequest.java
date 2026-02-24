package com.mchekhashvili.rental.dto.request.rental;

import com.mchekhashvili.rental.enums.MileageUnit;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VehicleRentalRequest extends BaseRentalRequest {

    @NotNull(message = "Mileage at rental is required")
    @Positive(message = "Mileage must be positive")
    private BigDecimal mileageAtRental;

    private MileageUnit mileageUnit = MileageUnit.KM;
}
