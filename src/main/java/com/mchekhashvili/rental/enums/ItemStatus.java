package com.mchekhashvili.rental.enums;

import lombok.Getter;

import java.util.Set;

@Getter
public enum ItemStatus {
    AVAILABLE("Item is available for rent"),
    RENTED("Item is currently rented"),
    DAMAGED("Item has been damaged"),
    LOST("Item has been lost");

    private final String description;
    private Set<ItemStatus> allowedTransitions;

    ItemStatus(String description) {
        this.description = description;
    }

    static {
        AVAILABLE.allowedTransitions = Set.of(RENTED);
        RENTED.allowedTransitions = Set.of(AVAILABLE, DAMAGED, LOST);
        DAMAGED.allowedTransitions = Set.of(LOST);
        LOST.allowedTransitions = Set.of(AVAILABLE);
    }

    public boolean canTransitionTo(ItemStatus newStatus) {
        return allowedTransitions.contains(newStatus);
    }
}
