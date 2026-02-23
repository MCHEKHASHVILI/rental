package com.mchekhashvili.rental.dto.response.item;

import com.mchekhashvili.rental.dto.response.BaseResponse;
import com.mchekhashvili.rental.enums.DeviceCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectronicDeviceItemResponse extends BaseResponse {
    private DeviceCategory category;
    private String manufacturer;
    private String serialNumber;
}