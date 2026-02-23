package com.mchekhashvili.rental.model.customer.document.corporate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "registration_certificates")
@Getter
@Setter
@NoArgsConstructor
public class RegistrationCertificate extends CorporateDocument {

    @Column(nullable = false, unique = true)
    private String registrationNumber;
}