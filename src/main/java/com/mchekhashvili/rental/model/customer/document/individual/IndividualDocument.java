package com.mchekhashvili.rental.model.customer.document.individual;

import com.mchekhashvili.rental.model.customer.document.IdentificationDocument;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "individual_documents")
@Getter
@Setter
@NoArgsConstructor
public abstract class IndividualDocument extends IdentificationDocument {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String nationality;
}