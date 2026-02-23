package com.mchekhashvili.rental.repository;

import com.mchekhashvili.rental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // You can add custom finder methods here if needed, e.g.:
    // List<Customer> findByFullNameContaining(String name);
}