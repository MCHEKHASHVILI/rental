package com.mchekhashvili.rental.dto.request.rental;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstructionRentalRequest extends BaseRentalRequest {

    @NotBlank(message = "Condition at rental is required")
    private String conditionAtRental;

    @NotNull(message = "Licensed operator requirement is required")
    private boolean requiresLicensedOperator;
}
