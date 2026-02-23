package com.mchekhashvili.rental.controller;

import com.mchekhashvili.rental.dto.customer.CreateCustomerRequest;
import com.mchekhashvili.rental.dto.customer.CustomerDto;
import com.mchekhashvili.rental.model.Customer;
import com.mchekhashvili.rental.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> index(){
        List<Customer> customers = customerService.getAll();
        return ResponseEntity.ok(customers);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> store(@Valid @RequestBody CreateCustomerRequest request, UriComponentsBuilder uriComponentsBuilder) {

        CustomerDto customer = customerService.create(request);

        URI locationUri = uriComponentsBuilder
                .path("/customers/{id}")
                .buildAndExpand(customer.getId())
                .toUri();

        return ResponseEntity.created(locationUri).body(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> show(@PathVariable Long id){
        CustomerDto customerDto = customerService.getCustomerById(id);

        if(customerDto == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customerDto);
    }

}
