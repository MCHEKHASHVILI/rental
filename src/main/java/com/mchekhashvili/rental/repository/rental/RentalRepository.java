package com.mchekhashvili.rental.repository.rental;

import com.mchekhashvili.rental.model.rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.List;

@NoRepositoryBean
public interface RentalRepository<T extends Rental> extends JpaRepository<T, Long> {
    List<T> findAllByRentalItemId(Long rentalItemId);
    List<T> findAllByCustomerId(Long customerId);
    List<T> findAllByBranchId(Long branchId);
}