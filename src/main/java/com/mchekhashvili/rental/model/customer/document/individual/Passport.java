package com.mchekhashvili.rental.model.customer.document.individual;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "passports")
@Getter
@Setter
@NoArgsConstructor
public class Passport extends IndividualDocument {
    @Column(nullable = false)
    private String placeOfBirth;
}