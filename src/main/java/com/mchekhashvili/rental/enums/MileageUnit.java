package com.mchekhashvili.rental.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MileageUnit {
    KM("Kilometers"),
    MILES("Miles");

    private final String description;
}