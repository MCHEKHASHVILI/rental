package com.mchekhashvili.rental.controller.customer;

import com.mchekhashvili.rental.dto.response.BaseResponse;
import com.mchekhashvili.rental.model.customer.Customer;
import com.mchekhashvili.rental.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractCustomerController<E extends Customer, RQ, RS extends BaseResponse> implements CustomerController<RQ, RS> {

    protected final CustomerService<E, RQ, RS> service;

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
    public ResponseEntity<RS> update(Long id, RQ request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}