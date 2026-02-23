package com.mchekhashvili.rental.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PermitType {
    TEMPORARY("Temporary residence permit"),
    PERMANENT("Permanent residence permit");

    private final String description;
}