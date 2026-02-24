package com.mchekhashvili.rental.controller.customer;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerController<RQ, RS> {
    ResponseEntity<List<RS>> index();
    ResponseEntity<List<RS>> inactive();
    ResponseEntity<RS> show(Long id);
    ResponseEntity<RS> store(RQ request);
    ResponseEntity<RS> update(Long id, RQ request);
    ResponseEntity<Void> delete(Long id);
    ResponseEntity<RS> restore(Long id);
}
