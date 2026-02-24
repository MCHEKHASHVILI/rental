package com.mchekhashvili.rental.dto.request.rental;

import com.mchekhashvili.rental.enums.MileageUnit;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class VehicleRentalRequest {

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
    private java.time.LocalDateTime dueDate;

    @NotNull(message = "Mileage at rental is required")
    @Positive(message = "Mileage must be positive")
    private BigDecimal mileageAtRental;

    private MileageUnit mileageUnit = MileageUnit.KM;
}