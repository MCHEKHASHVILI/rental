package com.mchekhashvili.rental.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentMethod {
    CASH("Cash payment"),
    CREDIT_CARD("Credit card payment"),
    DEBIT_CARD("Debit card payment"),
    BANK_TRANSFER("Bank transfer payment"),
    ONLINE("Online payment");

    private final String description;
}