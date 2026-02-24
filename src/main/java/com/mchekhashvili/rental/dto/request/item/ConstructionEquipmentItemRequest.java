package com.mchekhashvili.rental.dto.request.item;

import com.mchekhashvili.rental.enums.EquipmentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstructionEquipmentItemRequest extends BaseItemRequest {

    @NotNull(message = "Equipment type is required")
    private EquipmentType equipmentType;

    @NotBlank(message = "Manufacturer is required")
    private String manufacturer;
}
