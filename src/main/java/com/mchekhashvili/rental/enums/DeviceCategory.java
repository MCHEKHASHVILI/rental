package com.mchekhashvili.rental.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeviceCategory {
    LAPTOP("Laptop computers"),
    CAMERA("Camera equipment"),
    AUDIO("Audio equipment"),
    PRINTER("Printing equipment"),
    OTHER("Other electronic devices");

    private final String description;

}