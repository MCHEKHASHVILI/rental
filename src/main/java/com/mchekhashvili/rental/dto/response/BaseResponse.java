package com.mchekhashvili.rental.dto.response;

import com.mchekhashvili.rental.enums.RentalStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * Base for rental response DTOs — carries the rental lifecycle status.
 * id and branchId are inherited from BaseEntityResponse.
 */
@Getter
@Setter
public abstract class BaseResponse extends BaseEntityResponse {
    private RentalStatus status;
}
