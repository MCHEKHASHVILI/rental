package com.mchekhashvili.rental.dto.response;

import com.mchekhashvili.rental.enums.RentalStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * Base for rental response DTOs — carries the fields common to every rental:
 * id, branchId, and the current rental lifecycle status.
 */
@Getter
@Setter
public abstract class BaseResponse extends BaseEntityResponse {
    private Long branchId;
    private RentalStatus status;
}
