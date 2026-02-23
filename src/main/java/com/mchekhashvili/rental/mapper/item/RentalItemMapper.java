package com.mchekhashvili.rental.mapper.item;

import com.mchekhashvili.rental.model.item.RentalItem;

public interface RentalItemMapper<E extends RentalItem, RQ, RS> {
    E toEntity(RQ request);
    RS toResponse(E entity);
}