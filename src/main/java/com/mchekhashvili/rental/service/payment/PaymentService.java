package com.mchekhashvili.rental.service.payment;

import com.mchekhashvili.rental.dto.request.payment.PaymentRequest;
import com.mchekhashvili.rental.dto.response.payment.PaymentResponse;

import java.util.List;

public interface PaymentService {
    PaymentResponse save(PaymentRequest request);
    List<PaymentResponse> findByRentalId(Long rentalId);
    PaymentResponse findById(Long id);
}
