package com.mchekhashvili.rental.model.customer.document.individual;

import com.mchekhashvili.rental.enums.PermitType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "residence_permits")
@Getter
@Setter
@NoArgsConstructor
public class ResidencePermit extends IndividualDocument {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PermitType permitType;
}