package com.mchekhashvili.rental.controller.rental;

import com.mchekhashvili.rental.dto.request.rental.RentalStatusUpdateRequest;
import com.mchekhashvili.rental.dto.request.rental.VehicleRentalRequest;
import com.mchekhashvili.rental.dto.response.rental.VehicleRentalResponse;
import com.mchekhashvili.rental.model.rental.VehicleRental;
import com.mchekhashvili.rental.service.rental.VehicleRentalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle-rentals")
public class VehicleRentalController extends AbstractRentalController<VehicleRental, VehicleRentalRequest, VehicleRentalResponse> {

    public VehicleRentalController(VehicleRentalService service) {
        super(service);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<VehicleRentalResponse>> index() {
        return super.index();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<VehicleRentalResponse> show(@PathVariable Long id) {
        return super.show(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<VehicleRentalResponse> store(@Valid @RequestBody VehicleRentalRequest request) {
        return super.store(request);
    }

    @Override
    @PatchMapping("/{id}/status")
    public ResponseEntity<VehicleRentalResponse> updateStatus(@PathVariable Long id, @Valid @RequestBody RentalStatusUpdateRequest request) {
        return super.updateStatus(id, request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}
