package com.mchekhashvili.rental.service.item;

import com.mchekhashvili.rental.model.item.RentalItem;

import java.util.List;

public interface RentalItemService<E extends RentalItem, RQ, RS> {
    List<RS> findAll();
    List<RS> findAllLost();
    RS findById(Long id);
    RS save(RQ request);
    RS update(Long id, RQ request);
    void delete(Long id);
    RS restore(Long id);
}
