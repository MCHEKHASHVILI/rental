package com.mchekhashvili.rental.service.customer;

import com.mchekhashvili.rental.model.customer.Customer;

import java.util.List;

public interface CustomerService<E extends Customer, RQ, RS> {
    List<RS> findAll();
    List<RS> findAllDeleted();
    RS findById(Long id);
    RS save(RQ request);
    RS update(Long id, RQ request);
    void delete(Long id);
    RS restore(Long id);
}
