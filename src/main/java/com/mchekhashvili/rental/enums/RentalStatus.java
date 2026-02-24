package com.mchekhashvili.rental.enums;

import lombok.Getter;

import java.util.Set;

@Getter
public enum RentalStatus {
    RENTED("Rental is active"),
    RETURNED("Item has been returned"),
    DAMAGED("Item has been damaged during rental"),
    LOST("Item has been lost during rental");

    private final String description;
    private Set<RentalStatus> allowedTransitions;

    RentalStatus(String description) {
        this.description = description;
    }

    static {
        RENTED.allowedTransitions = Set.of(RETURNED, DAMAGED, LOST);
        RETURNED.allowedTransitions = Set.of();
        DAMAGED.allowedTransitions = Set.of(RETURNED, LOST);
        LOST.allowedTransitions = Set.of();
    }

    public boolean canTransitionTo(RentalStatus newStatus) {
        return allowedTransitions.contains(newStatus);
    }

    public boolean isClosed() {
        return this == RETURNED || this == LOST;
    }
}
