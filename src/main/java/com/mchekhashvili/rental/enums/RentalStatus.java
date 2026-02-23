package com.mchekhashvili.rental.enums;

import lombok.Getter;

import java.util.Set;
@Getter
public enum RentalStatus {
    AVAILABLE("Item is available for rent"),
    RENTED("Item is currently rented"),
    RETURNED("Item has been returned"),
    DAMAGED("Item has been damaged"),
    LOST("Item has been lost");

    private final String description;
    private Set<RentalStatus> allowedTransitions;

    RentalStatus(String description) {
        this.description = description;
    }

    static {
        AVAILABLE.allowedTransitions = Set.of(RENTED);
        RENTED.allowedTransitions = Set.of(RETURNED, DAMAGED, LOST);
        RETURNED.allowedTransitions = Set.of();
        DAMAGED.allowedTransitions = Set.of(RETURNED, LOST);
        LOST.allowedTransitions = Set.of();
    }

    public boolean canTransitionTo(RentalStatus newStatus) {
        return allowedTransitions.contains(newStatus);
    }
}