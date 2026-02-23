package com.mchekhashvili.rental.model.customer.document.individual;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "military_ids")
@Getter
@Setter
@NoArgsConstructor
public class MilitaryId extends IndividualDocument {

    @Column(nullable = false)
    private String rank;

    @Column(nullable = false, unique = true)
    private String serviceNumber;
}