package com.mchekhashvili.rental.dto.response.payment;

import com.mchekhashvili.rental.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentResponse {
    private Long id;
    private Long rentalId;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private LocalDateTime paidAt;
    private String notes;
}
