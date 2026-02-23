package com.mchekhashvili.rental.controller.customer;

import com.mchekhashvili.rental.dto.request.customer.IndividualCustomerRequest;
import com.mchekhashvili.rental.dto.response.customer.IndividualCustomerResponse;
import com.mchekhashvili.rental.model.customer.IndividualCustomer;
import com.mchekhashvili.rental.service.customer.IndividualCustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/individual-customers")
public class IndividualCustomerController extends AbstractCustomerController<IndividualCustomer, IndividualCustomerRequest, IndividualCustomerResponse> {

    public IndividualCustomerController(IndividualCustomerService service) {
        super(service);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<IndividualCustomerResponse>> index() {
        return super.index();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<IndividualCustomerResponse> show(@PathVariable Long id) {
        return super.show(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<IndividualCustomerResponse> store(@Valid @RequestBody IndividualCustomerRequest request) {
        return super.store(request);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<IndividualCustomerResponse> update(@PathVariable Long id, @Valid @RequestBody IndividualCustomerRequest request) {
        return super.update(id, request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}