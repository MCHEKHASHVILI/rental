package com.mchekhashvili.rental.controller.rental;

import com.mchekhashvili.rental.dto.request.rental.ElectronicDeviceRentalRequest;
import com.mchekhashvili.rental.dto.request.rental.RentalStatusUpdateRequest;
import com.mchekhashvili.rental.dto.response.rental.ElectronicDeviceRentalResponse;
import com.mchekhashvili.rental.model.rental.ElectronicDeviceRental;
import com.mchekhashvili.rental.service.rental.ElectronicDeviceRentalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/electronic-device-rentals")
public class ElectronicDeviceRentalController extends AbstractRentalController<ElectronicDeviceRental, ElectronicDeviceRentalRequest, ElectronicDeviceRentalResponse> {

    public ElectronicDeviceRentalController(ElectronicDeviceRentalService service) {
        super(service);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ElectronicDeviceRentalResponse>> index() {
        return super.index();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ElectronicDeviceRentalResponse> show(@PathVariable Long id) {
        return super.show(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<ElectronicDeviceRentalResponse> store(@Valid @RequestBody ElectronicDeviceRentalRequest request) {
        return super.store(request);
    }

    @Override
    @PatchMapping("/{id}/status")
    public ResponseEntity<ElectronicDeviceRentalResponse> updateStatus(@PathVariable Long id, @Valid @RequestBody RentalStatusUpdateRequest request) {
        return super.updateStatus(id, request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}
