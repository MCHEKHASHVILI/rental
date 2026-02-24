package com.mchekhashvili.rental.controller.customer;

import com.mchekhashvili.rental.dto.response.BaseResponse;
import com.mchekhashvili.rental.model.customer.Customer;
import com.mchekhashvili.rental.service.customer.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractCustomerController<E extends Customer, RQ, RS extends BaseResponse>
        implements CustomerController<RQ, RS> {

    protected final CustomerService<E, RQ, RS> service;

    @Override
    @GetMapping
    public ResponseEntity<List<RS>> index() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    @GetMapping("/inactive")
    public ResponseEntity<List<RS>> inactive() {
        return ResponseEntity.ok(service.findAllInactive());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<RS> show(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<RS> store(@Valid @RequestBody RQ request) {
        RS saved = service.save(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<RS> update(@PathVariable Long id, @Valid @RequestBody RQ request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PatchMapping("/{id}/restore")
    public ResponseEntity<RS> restore(@PathVariable Long id) {
        return ResponseEntity.ok(service.restore(id));
    }
}
