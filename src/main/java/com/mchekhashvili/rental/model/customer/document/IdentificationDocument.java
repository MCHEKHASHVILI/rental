package com.mchekhashvili.rental.model.customer.document;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "identification_documents")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public abstract class IdentificationDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String documentNumber;

    @Column(nullable = false)
    private LocalDate issueDate;

    @Column
    private LocalDate expiryDate;

    @Column(nullable = false)
    private String issuingAuthority;
}