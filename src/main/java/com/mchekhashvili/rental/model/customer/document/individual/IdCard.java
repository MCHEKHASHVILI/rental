package com.mchekhashvili.rental.model.customer.document.individual;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "id_cards")
@Getter
@Setter
@NoArgsConstructor
public class IdCard extends IndividualDocument {

    @Column(nullable = false, unique = true)
    private String personalNumber;
}