package com.mchekhashvili.rental.dto.response.item;

import com.mchekhashvili.rental.dto.response.BaseItemResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleItemResponse extends BaseItemResponse {
    private String make;
    private String model;
    private Integer yearOfManufacture;
}
