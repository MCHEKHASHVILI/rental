package com.mchekhashvili.rental.dto.response.rental;

import com.mchekhashvili.rental.dto.response.BaseResponse;
import com.mchekhashvili.rental.enums.MileageUnit;
import com.mchekhashvili.rental.enums.RentalStatus;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class VehicleRentalResponse extends BaseResponse {
    private Long customerId;
    private Long branchId;
    private Long rentalItemId;
    private LocalDateTime rentedAt;
    private LocalDateTime dueDate;
    private BigDecimal deposit;
    private BigDecimal monthlyFee;
    private RentalStatus status;
    private BigDecimal mileageAtRental;
    private MileageUnit mileageUnit;
}