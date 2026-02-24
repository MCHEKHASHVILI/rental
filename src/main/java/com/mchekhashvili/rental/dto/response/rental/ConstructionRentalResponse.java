package com.mchekhashvili.rental.dto.response.rental;

import com.mchekhashvili.rental.dto.response.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ConstructionRentalResponse extends BaseResponse {
    private Long customerId;
    private Long rentalItemId;
    private LocalDateTime rentedAt;
    private LocalDateTime dueDate;
    private BigDecimal deposit;
    private BigDecimal monthlyFee;
    private BigDecimal lateFeePerDay;
    private String conditionAtRental;
    private boolean requiresLicensedOperator;
}
