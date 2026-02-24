package com.mchekhashvili.rental.dto.response;

import com.mchekhashvili.rental.enums.RentalStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Base for all rental response DTOs.
 * Holds fields common to every rental type; subtypes add only their own specific fields.
 */
@Getter
@Setter
public abstract class BaseResponse extends BaseEntityResponse {
    private Long customerId;
    private Long rentalItemId;
    private RentalStatus status;
    private LocalDateTime rentedAt;
    private LocalDateTime dueDate;
    private BigDecimal deposit;
    private BigDecimal monthlyFee;
    private BigDecimal lateFeePerDay;
}
