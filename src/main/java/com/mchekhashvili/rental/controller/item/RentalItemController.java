package com.mchekhashvili.rental.controller.item;

import java.util.List;

public interface RentalItemController<RQ, RS> {
    List<RS> index();
    List<RS> lost();
    RS show(Long id);
    RS store(RQ request);
    RS update(Long id, RQ request);
    void delete(Long id);
    RS restore(Long id);
}
