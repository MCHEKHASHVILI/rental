package com.mchekhashvili.rental.controller.payment;

import com.mchekhashvili.rental.dto.request.payment.PaymentRequest;
import com.mchekhashvili.rental.dto.response.payment.PaymentResponse;
import com.mchekhashvili.rental.service.payment.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponse> store(@Valid @RequestBody PaymentRequest request) {
        PaymentResponse saved = paymentService.save(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.findById(id));
    }

    @GetMapping("/rental/{rentalId}")
    public ResponseEntity<List<PaymentResponse>> byRental(@PathVariable Long rentalId) {
        return ResponseEntity.ok(paymentService.findByRentalId(rentalId));
    }
}
