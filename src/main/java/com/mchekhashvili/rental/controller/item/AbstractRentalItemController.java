package com.mchekhashvili.rental.controller.item;

import com.mchekhashvili.rental.dto.response.BaseItemResponse;
import com.mchekhashvili.rental.model.item.RentalItem;
import com.mchekhashvili.rental.service.item.RentalItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractRentalItemController<E extends RentalItem, RQ, RS extends BaseItemResponse>
        implements RentalItemController<RQ, RS> {

    protected final RentalItemService<E, RQ, RS> service;

    @Override
    @GetMapping
    public ResponseEntity<List<RS>> index() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    @GetMapping("/lost")
    public ResponseEntity<List<RS>> lost() {
        return ResponseEntity.ok(service.findAllLost());
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
