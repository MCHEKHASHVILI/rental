package com.mchekhashvili.rental.dto.request.rental;

import com.mchekhashvili.rental.enums.RentalStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalStatusUpdateRequest {

    @NotNull(message = "Status is required")
    private RentalStatus status;

    @NotBlank(message = "Reason is required")
    private String reason;
}
