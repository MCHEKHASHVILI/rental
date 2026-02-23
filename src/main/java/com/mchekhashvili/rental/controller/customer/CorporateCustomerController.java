package com.mchekhashvili.rental.controller.customer;

import com.mchekhashvili.rental.dto.request.customer.CorporateCustomerRequest;
import com.mchekhashvili.rental.dto.response.customer.CorporateCustomerResponse;
import com.mchekhashvili.rental.model.customer.CorporateCustomer;
import com.mchekhashvili.rental.service.customer.CorporateCustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/corporate-customers")
public class CorporateCustomerController extends AbstractCustomerController<CorporateCustomer, CorporateCustomerRequest, CorporateCustomerResponse> {

    public CorporateCustomerController(CorporateCustomerService service) {
        super(service);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CorporateCustomerResponse>> index() {
        return super.index();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CorporateCustomerResponse> show(@PathVariable Long id) {
        return super.show(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<CorporateCustomerResponse> store(@Valid @RequestBody CorporateCustomerRequest request) {
        return super.store(request);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<CorporateCustomerResponse> update(@PathVariable Long id, @Valid @RequestBody CorporateCustomerRequest request) {
        return super.update(id, request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}