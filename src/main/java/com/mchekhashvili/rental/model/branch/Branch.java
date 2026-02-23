package com.mchekhashvili.rental.model.branch;

import com.mchekhashvili.rental.model.item.RentalItem;
import com.mchekhashvili.rental.model.rental.Rental;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "branches")
@Getter
@Setter
@NoArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column
    private String phone;

    @Column
    private String email;

    @Column(nullable = false)
    private boolean active = true;

    @ToString.Exclude
    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    private List<RentalItem> rentalItems = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    private List<Rental> rentals = new ArrayList<>();
}