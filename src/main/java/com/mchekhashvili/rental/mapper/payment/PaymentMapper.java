package com.mchekhashvili.rental.mapper.payment;

import com.mchekhashvili.rental.dto.request.payment.PaymentRequest;
import com.mchekhashvili.rental.dto.response.payment.PaymentResponse;
import com.mchekhashvili.rental.model.payment.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rental", ignore = true)
    @Mapping(target = "paidAt", ignore = true)
    Payment toEntity(PaymentRequest request);

    @Mapping(target = "rentalId", source = "rental.id")
    PaymentResponse toResponse(Payment payment);
}
