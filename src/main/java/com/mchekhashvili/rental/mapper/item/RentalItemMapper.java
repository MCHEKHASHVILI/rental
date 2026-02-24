package com.mchekhashvili.rental.mapper.item;

import com.mchekhashvili.rental.model.item.RentalItem;
import org.mapstruct.MappingTarget;

public interface RentalItemMapper<E extends RentalItem, RQ, RS> {
    E toEntity(RQ request);
    RS toResponse(E entity);
    void updateEntity(RQ request, @MappingTarget E entity);
}
