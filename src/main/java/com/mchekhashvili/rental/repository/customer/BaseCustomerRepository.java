package com.mchekhashvili.rental.repository.customer;

import com.mchekhashvili.rental.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BaseCustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByActiveTrue();
    Optional<Customer> findByIdAndActiveTrue(Long id);
}
