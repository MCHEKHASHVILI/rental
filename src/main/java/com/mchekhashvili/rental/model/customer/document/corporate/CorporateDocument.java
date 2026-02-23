package com.mchekhashvili.rental.model.customer.document.corporate;

import com.mchekhashvili.rental.model.customer.document.IdentificationDocument;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "corporate_documents")
@Getter
@Setter
@NoArgsConstructor
public abstract class CorporateDocument extends IdentificationDocument {

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String legalAddress;
}