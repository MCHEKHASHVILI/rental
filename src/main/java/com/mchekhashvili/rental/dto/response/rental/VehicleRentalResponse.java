package com.mchekhashvili.rental.dto.response.rental;

import com.mchekhashvili.rental.dto.response.BaseResponse;
import com.mchekhashvili.rental.enums.MileageUnit;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VehicleRentalResponse extends BaseResponse {
    private BigDecimal mileageAtRental;
    private MileageUnit mileageUnit;
}
