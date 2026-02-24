package com.mchekhashvili.rental.service.scheduled;

import com.mchekhashvili.rental.enums.RentalStatus;
import com.mchekhashvili.rental.model.payment.Payment;
import com.mchekhashvili.rental.model.rental.Rental;
import com.mchekhashvili.rental.model.rental.RentalStatusHistory;
import com.mchekhashvili.rental.repository.payment.PaymentRepository;
import com.mchekhashvili.rental.repository.rental.BaseRentalRepository;
import com.mchekhashvili.rental.repository.rental.RentalStatusHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentalSchedulerService {

    private final BaseRentalRepository rentalRepository;
    private final PaymentRepository paymentRepository;
    private final RentalStatusHistoryRepository statusHistoryRepository;

    /**
     * Runs every day at 00:00:01.
     * Finds all active rentals past their due date and applies late fee charges.
     */
    @Transactional
    @Scheduled(cron = "1 0 0 * * *")
    public void applyLateFees() {
        LocalDateTime now = LocalDateTime.now();
        List<Rental> overdueRentals = rentalRepository
                .findAllByStatusAndDueDateBefore(RentalStatus.RENTED, now);

        if (overdueRentals.isEmpty()) {
            log.info("Late fee job: no overdue rentals found.");
            return;
        }

        for (Rental rental : overdueRentals) {
            if (rental.getLateFeePerDay().compareTo(BigDecimal.ZERO) <= 0) {
                continue; // no late fee configured for this rental
            }

            long daysOverdue = ChronoUnit.DAYS.between(rental.getDueDate(), now);
            if (daysOverdue <= 0) {
                continue;
            }

            BigDecimal lateFee = rental.getLateFeePerDay().multiply(BigDecimal.valueOf(daysOverdue));

            // Record the late fee as a system payment entry
            Payment feePayment = new Payment();
            feePayment.setRental(rental);
            feePayment.setAmount(lateFee);
            feePayment.setPaidAt(now);
            feePayment.setNotes("Automatic late fee: " + daysOverdue + " day(s) overdue @ "
                    + rental.getLateFeePerDay() + " per day");
            // No payment method — system-generated entry (null is intentional here)
            paymentRepository.save(feePayment);

            log.info("Applied late fee of {} to rental id={} ({} days overdue)",
                    lateFee, rental.getId(), daysOverdue);
        }

        log.info("Late fee job complete. Processed {} overdue rentals.", overdueRentals.size());
    }
}
