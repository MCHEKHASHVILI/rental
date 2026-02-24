package com.mchekhashvili.rental.dto.request.rental;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectronicDeviceRentalRequest extends BaseRentalRequest {

    @NotNull(message = "Damaged status is required")
    private boolean isDamaged;

    private String damageDescription;
}
