package com.mchekhashvili.rental.controller.rental;

import com.mchekhashvili.rental.dto.request.rental.RentalStatusUpdateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RentalController<RQ, RS> {
    ResponseEntity<List<RS>> index();
    ResponseEntity<RS> show(Long id);
    ResponseEntity<RS> store(RQ request);
    ResponseEntity<RS> updateStatus(Long id, RentalStatusUpdateRequest request);
    ResponseEntity<Void> delete(Long id);
}
