package com.mchekhashvili.rental.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EquipmentType {
    LIGHT("Light equipment"),
    HEAVY("Heavy equipment");

    private final String description;

}