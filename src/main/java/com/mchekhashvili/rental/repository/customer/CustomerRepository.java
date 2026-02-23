package com.mchekhashvili.rental.repository.customer;

import com.mchekhashvili.rental.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface CustomerRepository<T extends Customer> extends JpaRepository<T, Long> {
    List<T> findAllByActiveTrue();
    Optional<T> findByIdAndActiveTrue(Long id);
}