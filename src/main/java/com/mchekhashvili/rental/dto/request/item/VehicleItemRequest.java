package com.mchekhashvili.rental.dto.request.item;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleItemRequest extends BaseItemRequest {

    @NotBlank(message = "Make is required")
    private String make;

    @NotBlank(message = "Model is required")
    private String model;

    @NotNull(message = "Year of manufacture is required")
    @Min(value = 1900, message = "Year of manufacture must be after 1900")
    private Integer yearOfManufacture;
}
