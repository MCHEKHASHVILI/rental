package com.mchekhashvili.rental.controller.rental;

import com.mchekhashvili.rental.dto.request.rental.ConstructionRentalRequest;
import com.mchekhashvili.rental.dto.response.rental.ConstructionRentalResponse;
import com.mchekhashvili.rental.model.rental.ConstructionRental;
import com.mchekhashvili.rental.service.rental.ConstructionRentalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/construction-rentals")
public class ConstructionRentalController extends AbstractRentalController<ConstructionRental, ConstructionRentalRequest, ConstructionRentalResponse> {

    public ConstructionRentalController(ConstructionRentalService service) {
        super(service);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ConstructionRentalResponse>> index() {
        return super.index();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ConstructionRentalResponse> show(@PathVariable Long id) {
        return super.show(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<ConstructionRentalResponse> store(@Valid @RequestBody ConstructionRentalRequest request) {
        return super.store(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}