package com.mchekhashvili.rental.controller.item;

import com.mchekhashvili.rental.dto.request.item.ConstructionEquipmentItemRequest;
import com.mchekhashvili.rental.dto.response.item.ConstructionEquipmentItemResponse;
import com.mchekhashvili.rental.model.item.ConstructionEquipmentItem;
import com.mchekhashvili.rental.service.item.ConstructionEquipmentItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/construction-equipment")
public class ConstructionEquipmentItemController extends AbstractRentalItemController<ConstructionEquipmentItem, ConstructionEquipmentItemRequest, ConstructionEquipmentItemResponse> {

    public ConstructionEquipmentItemController(ConstructionEquipmentItemService service) {
        super(service);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ConstructionEquipmentItemResponse>> index() {
        return super.index();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ConstructionEquipmentItemResponse> show(@PathVariable Long id) {
        return super.show(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<ConstructionEquipmentItemResponse> store(@Valid @RequestBody ConstructionEquipmentItemRequest request) {
        return super.store(request);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ConstructionEquipmentItemResponse> update(@PathVariable Long id, @Valid @RequestBody ConstructionEquipmentItemRequest request) {
        return super.update(id, request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}