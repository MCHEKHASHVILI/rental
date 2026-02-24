package com.mchekhashvili.rental.controller.customer;

import java.util.List;

public interface CustomerController<RQ, RS> {
    List<RS> index();
    List<RS> deleted();
    RS show(Long id);
    RS store(RQ request);
    RS update(Long id, RQ request);
    void delete(Long id);
    RS restore(Long id);
}
