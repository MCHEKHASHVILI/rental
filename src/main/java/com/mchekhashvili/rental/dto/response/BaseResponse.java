package com.mchekhashvili.rental.dto.response;

import com.mchekhashvili.rental.enums.RentalStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseResponse {
    private Long id;
    private Long branchId;
    private RentalStatus status;
}