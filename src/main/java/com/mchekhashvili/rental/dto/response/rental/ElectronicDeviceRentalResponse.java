package com.mchekhashvili.rental.dto.response.rental;

import com.mchekhashvili.rental.dto.response.BaseRentalResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectronicDeviceRentalResponse extends BaseRentalResponse {
    private boolean isDamaged;
    private String damageDescription;
}
