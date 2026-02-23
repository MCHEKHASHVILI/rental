package com.mchekhashvili.rental.model.customer.document.corporate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "business_licenses")
@Getter
@Setter
@NoArgsConstructor
public class BusinessLicense extends CorporateDocument {

    @Column(nullable = false)
    private String licenseType;

    @Column(nullable = false)
    private String licenseCategory;
}