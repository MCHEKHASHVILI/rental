package com.mchekhashvili.rental.controller.branch;

import com.mchekhashvili.rental.dto.request.branch.BranchRequest;
import com.mchekhashvili.rental.dto.response.branch.BranchResponse;
import com.mchekhashvili.rental.service.branch.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService service;

    @GetMapping
    public ResponseEntity<List<BranchResponse>> index() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/deleted")
    public ResponseEntity<List<BranchResponse>> deleted() {
        return ResponseEntity.ok(service.findAllDeleted());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchResponse> show(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<BranchResponse> store(@Valid @RequestBody BranchRequest request) {
        BranchResponse saved = service.save(request);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchResponse> update(@PathVariable Long id, @Valid @RequestBody BranchRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/restore")
    public ResponseEntity<BranchResponse> restore(@PathVariable Long id) {
        return ResponseEntity.ok(service.restore(id));
    }
}
