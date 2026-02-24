package com.mchekhashvili.rental.repository.payment;

import com.mchekhashvili.rental.model.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findAllByRentalIdOrderByPaidAtAsc(Long rentalId);

    @Query("SELECT COALESCE(SUM(p.amount), 0) FROM Payment p WHERE p.rental.id = :rentalId")
    BigDecimal sumAmountByRentalId(Long rentalId);
}
