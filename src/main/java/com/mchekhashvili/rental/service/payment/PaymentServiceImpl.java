package com.mchekhashvili.rental.service.payment;

import com.mchekhashvili.rental.dto.request.payment.PaymentRequest;
import com.mchekhashvili.rental.dto.response.payment.PaymentResponse;
import com.mchekhashvili.rental.mapper.payment.PaymentMapper;
import com.mchekhashvili.rental.model.payment.Payment;
import com.mchekhashvili.rental.model.rental.Rental;
import com.mchekhashvili.rental.repository.payment.PaymentRepository;
import com.mchekhashvili.rental.repository.rental.RentalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    // Base rental repository typed to Rental (the abstract parent) for payment lookups
    private final RentalRepository<Rental> rentalRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;

    @Override
    public PaymentResponse save(PaymentRequest request) {
        Long rentalId = request.getRentalId();
        Rental rental = rentalRepository.findById(rentalId)
                .orElseThrow(() -> new EntityNotFoundException("Rental not found with id: " + rentalId));

        // Payments are not allowed once a rental is closed (RETURNED or LOST)
        if (rental.getStatus().isClosed()) {
            throw new IllegalStateException(
                    "Payments are not allowed for rentals with status: " + rental.getStatus());
        }

        Payment payment = mapper.toEntity(request);
        payment.setRental(rental);
        payment.setPaidAt(LocalDateTime.now());

        return mapper.toResponse(paymentRepository.save(payment));
    }

    @Override
    public List<PaymentResponse> findByRentalId(Long rentalId) {
        if (!rentalRepository.existsById(rentalId)) {
            throw new EntityNotFoundException("Rental not found with id: " + rentalId);
        }
        return paymentRepository.findAllByRentalIdOrderByPaidAtAsc(rentalId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public PaymentResponse findById(Long id) {
        return mapper.toResponse(
                paymentRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Payment not found with id: " + id)));
    }
}
