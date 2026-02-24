package com.mchekhashvili.rental.dto.request.rental;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ElectronicDeviceRentalRequest {

    @NotNull(message = "Customer is required")
    private Long customerId;

    @NotNull(message = "Branch is required")
    private Long branchId;

    @NotNull(message = "Rental item is required")
    private Long rentalItemId;

    @NotNull(message = "Deposit is required")
    @Positive(message = "Deposit must be positive")
    private BigDecimal deposit;

    @NotNull(message = "Monthly fee is required")
    @Positive(message = "Monthly fee must be positive")
    private BigDecimal monthlyFee;

    @NotNull(message = "Due date is required")
    private LocalDateTime dueDate;

    @NotNull(message = "Damaged status is required")
    private boolean isDamaged;

    private String damageDescription;
}