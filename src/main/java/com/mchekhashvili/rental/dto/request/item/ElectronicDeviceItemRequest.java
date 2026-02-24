package com.mchekhashvili.rental.dto.request.item;

import com.mchekhashvili.rental.enums.DeviceCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectronicDeviceItemRequest extends BaseItemRequest {

    @NotNull(message = "Category is required")
    private DeviceCategory category;

    @NotBlank(message = "Manufacturer is required")
    private String manufacturer;

    @NotBlank(message = "Serial number is required")
    private String serialNumber;
}
