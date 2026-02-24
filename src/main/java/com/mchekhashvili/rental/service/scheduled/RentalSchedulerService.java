package com.mchekhashvili.rental.service.scheduled;

import com.mchekhashvili.rental.enums.RentalStatus;
import com.mchekhashvili.rental.model.payment.Payment;
import com.mchekhashvili.rental.model.rental.Rental;
import com.mchekhashvili.rental.repository.payment.PaymentRepository;
import com.mchekhashvili.rental.repository.rental.BaseRentalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentalSchedulerService {

    private final BaseRentalRepository rentalRepository;
    private final PaymentRepository paymentRepository;

    /**
     * Runs every day at 00:00:01.
     * For each overdue active rental that has a late fee configured,
     * charges exactly one day's late fee (since this job runs once per day).
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

        int charged = 0;
        for (Rental rental : overdueRentals) {
            if (rental.getLateFeePerDay().compareTo(BigDecimal.ZERO) <= 0) {
                continue;
            }

            // Charge exactly one day's fee per daily run
            BigDecimal lateFee = rental.getLateFeePerDay();

            Payment feePayment = new Payment();
            feePayment.setRental(rental);
            feePayment.setAmount(lateFee);
            feePayment.setPaidAt(now);
            feePayment.setNotes("Automatic daily late fee for overdue rental (due: " + rental.getDueDate() + ")");
            paymentRepository.save(feePayment);
            charged++;
        }

        log.info("Late fee job complete. Charged {} overdue rentals.", charged);
    }
}
