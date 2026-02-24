package com.mchekhashvili.rental.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Minimal base for all response DTOs — carries only the entity ID.
 * Subclasses add their own domain-specific fields.
 */
@Getter
@Setter
public abstract class BaseEntityResponse {
    private Long id;
}
