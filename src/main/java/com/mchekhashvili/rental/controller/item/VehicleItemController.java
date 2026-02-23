package com.mchekhashvili.rental.controller.item;

import com.mchekhashvili.rental.dto.request.item.VehicleItemRequest;
import com.mchekhashvili.rental.dto.response.item.VehicleItemResponse;
import com.mchekhashvili.rental.model.item.VehicleItem;
import com.mchekhashvili.rental.service.item.VehicleItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleItemController extends AbstractRentalItemController<VehicleItem, VehicleItemRequest, VehicleItemResponse> {

    public VehicleItemController(VehicleItemService service) {
        super(service);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<VehicleItemResponse>> index() {
        return super.index();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<VehicleItemResponse> show(@PathVariable Long id) {
        return super.show(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<VehicleItemResponse> store(@Valid @RequestBody VehicleItemRequest request) {
        return super.store(request);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<VehicleItemResponse> update(@PathVariable Long id, @Valid @RequestBody VehicleItemRequest request) {
        return super.update(id, request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}