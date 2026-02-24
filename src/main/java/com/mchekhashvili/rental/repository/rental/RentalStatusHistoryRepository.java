package com.mchekhashvili.rental.repository.rental;

import com.mchekhashvili.rental.model.rental.RentalStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalStatusHistoryRepository extends JpaRepository<RentalStatusHistory, Long> {
    List<RentalStatusHistory> findAllByRentalIdOrderByChangedAtAsc(Long rentalId);
}
