package com.mchekhashvili.rental.repository.rental;

import com.mchekhashvili.rental.enums.RentalStatus;
import com.mchekhashvili.rental.model.rental.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BaseRentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findAllByStatusAndDueDateBefore(RentalStatus status, LocalDateTime dateTime);
}
