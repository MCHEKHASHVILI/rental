package com.mchekhashvili.rental.service.rental;

import com.mchekhashvili.rental.model.rental.Rental;
import java.util.List;

public interface RentalService<E extends Rental, RQ, RS> {
    List<RS> findAll();
    RS findById(Long id);
    RS save(RQ request);
    void delete(Long id);
}