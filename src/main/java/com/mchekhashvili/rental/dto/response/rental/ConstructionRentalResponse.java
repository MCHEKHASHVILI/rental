package com.mchekhashvili.rental.dto.response.rental;

import com.mchekhashvili.rental.dto.response.BaseRentalResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstructionRentalResponse extends BaseRentalResponse {
    private String conditionAtRental;
    private boolean requiresLicensedOperator;
}
