package com.mchekhashvili.rental.repository.customer;

import com.mchekhashvili.rental.model.customer.CorporateCustomer;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateCustomerRepository extends CustomerRepository<CorporateCustomer> {
}