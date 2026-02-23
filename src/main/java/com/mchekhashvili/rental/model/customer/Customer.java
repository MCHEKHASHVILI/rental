package com.mchekhashvili.rental.model.customer;

import com.mchekhashvili.rental.model.customer.document.IdentificationDocument;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public abstract class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean active = true;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "identification_document_id", nullable = false)
    private IdentificationDocument identificationDocument;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String phone;

    @Column
    private String address;
}