package com.mchekhashvili.rental.model.rental;

import com.mchekhashvili.rental.enums.RentalStatus;
import com.mchekhashvili.rental.model.branch.Branch;
import com.mchekhashvili.rental.model.customer.Customer;
import com.mchekhashvili.rental.model.item.RentalItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rentals")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public abstract class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_item_id", nullable = false)
    private RentalItem rentalItem;

    @Column(nullable = false)
    private LocalDateTime rentedAt;

    @Column
    private LocalDateTime dueDate;

    @Column(nullable = false)
    private BigDecimal deposit;

    @Column(nullable = false)
    private BigDecimal monthlyFee;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RentalStatus status = RentalStatus.RENTED;

    @ToString.Exclude
    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private List<RentalStatusHistory> statusHistory = new ArrayList<>();

}