package com.mchekhashvili.rental.controller.rental;

import org.springframework.http.ResponseEntity;
import java.util.List;

public interface RentalController<RQ, RS> {
    ResponseEntity<List<RS>> index();
    ResponseEntity<RS> show(Long id);
    ResponseEntity<RS> store(RQ request);
    ResponseEntity<Void> delete(Long id);
}