package com.mchekhashvili.rental.model.rental;

import com.mchekhashvili.rental.enums.RentalStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "rental_status_history")
@Getter
@Setter
@NoArgsConstructor
public class RentalStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rental;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RentalStatus status;

    @Column(nullable = false)
    private LocalDateTime changedAt;

    @Column(nullable = false)
    private String reason;

}