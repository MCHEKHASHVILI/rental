package com.mchekhashvili.rental.controller.item;

import com.mchekhashvili.rental.dto.request.item.ElectronicDeviceItemRequest;
import com.mchekhashvili.rental.dto.response.item.ElectronicDeviceItemResponse;
import com.mchekhashvili.rental.model.item.ElectronicDeviceItem;
import com.mchekhashvili.rental.service.item.ElectronicDeviceItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/electronic-devices")
public class ElectronicDeviceItemController extends AbstractRentalItemController<ElectronicDeviceItem, ElectronicDeviceItemRequest, ElectronicDeviceItemResponse> {

    public ElectronicDeviceItemController(ElectronicDeviceItemService service) {
        super(service);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ElectronicDeviceItemResponse>> index() {
        return super.index();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ElectronicDeviceItemResponse> show(@PathVariable Long id) {
        return super.show(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<ElectronicDeviceItemResponse> store(@Valid @RequestBody ElectronicDeviceItemRequest request) {
        return super.store(request);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ElectronicDeviceItemResponse> update(@PathVariable Long id, @Valid @RequestBody ElectronicDeviceItemRequest request) {
        return super.update(id, request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}