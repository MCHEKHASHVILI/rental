package com.mchekhashvili.rental.mapper.rental;

import com.mchekhashvili.rental.model.rental.Rental;

public interface RentalMapper<E extends Rental, RQ, RS> {
    E toEntity(RQ request);
    RS toResponse(E entity);
}