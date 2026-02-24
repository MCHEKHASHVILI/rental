package com.mchekhashvili.rental.dto.request.item;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseItemRequest {

    @NotNull(message = "Branch is required")
    private Long branchId;
}
