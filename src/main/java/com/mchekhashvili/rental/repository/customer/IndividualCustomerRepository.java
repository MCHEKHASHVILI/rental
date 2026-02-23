package com.mchekhashvili.rental.repository.customer;

import com.mchekhashvili.rental.model.customer.IndividualCustomer;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualCustomerRepository extends CustomerRepository<IndividualCustomer> {
}