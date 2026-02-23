package com.mchekhashvili.rental.model.customer.document.corporate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tax_certificates")
@Getter
@Setter
@NoArgsConstructor
public class TaxCertificate extends CorporateDocument {

    @Column(nullable = false, unique = true)
    private String taxIdentificationNumber;
}