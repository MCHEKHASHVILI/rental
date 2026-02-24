package com.mchekhashvili.rental.dto.response.item;

import com.mchekhashvili.rental.dto.response.BaseItemResponse;
import com.mchekhashvili.rental.enums.DeviceCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectronicDeviceItemResponse extends BaseItemResponse {
    private DeviceCategory category;
    private String manufacturer;
    private String serialNumber;
}
