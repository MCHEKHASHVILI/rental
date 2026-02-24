package com.mchekhashvili.rental.dto.response.rental;

import com.mchekhashvili.rental.dto.response.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectronicDeviceRentalResponse extends BaseResponse {
    private boolean isDamaged;
    private String damageDescription;
}
