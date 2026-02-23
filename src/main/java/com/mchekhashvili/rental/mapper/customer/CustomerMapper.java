package com.mchekhashvili.rental.mapper.customer;

import com.mchekhashvili.rental.model.customer.Customer;

public interface CustomerMapper<E extends Customer, RQ, RS> {
    E toEntity(RQ request);
    RS toResponse(E entity);
    void updateEntity(RQ request, E entity);
}