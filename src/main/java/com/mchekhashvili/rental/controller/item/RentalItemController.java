package com.mchekhashvili.rental.controller.item;

import org.springframework.http.ResponseEntity;
import java.util.List;

public interface RentalItemController<RQ, RS> {
    ResponseEntity<List<RS>> index();
    ResponseEntity<RS> show(Long id);
    ResponseEntity<RS> store(RQ request);
    ResponseEntity<RS> update(Long id, RQ request);
    ResponseEntity<Void> delete(Long id);
}