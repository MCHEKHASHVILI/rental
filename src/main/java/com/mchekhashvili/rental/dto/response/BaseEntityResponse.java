package com.mchekhashvili.rental.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Minimal base for all response DTOs.
 * Every entity in the system has an id and belongs to a branch.
 */
@Getter
@Setter
public abstract class BaseEntityResponse {
    private Long id;
    private Long branchId;
}
