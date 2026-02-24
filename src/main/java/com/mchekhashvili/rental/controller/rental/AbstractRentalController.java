package com.mchekhashvili.rental.controller.rental;

import com.mchekhashvili.rental.dto.request.rental.RentalStatusUpdateRequest;
import com.mchekhashvili.rental.dto.response.BaseResponse;
import com.mchekhashvili.rental.model.rental.Rental;
import com.mchekhashvili.rental.service.rental.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractRentalController<E extends Rental, RQ, RS extends BaseResponse> implements RentalController<RQ, RS> {

    protected final RentalService<E, RQ, RS> service;

    @Override
    public ResponseEntity<List<RS>> index() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<RS> show(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<RS> store(RQ request) {
        RS saved = service.save(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @Override
    public ResponseEntity<RS> updateStatus(Long id, RentalStatusUpdateRequest request) {
        return ResponseEntity.ok(service.updateStatus(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
