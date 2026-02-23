package com.mchekhashvili.rental.dto.response.item;

import com.mchekhashvili.rental.dto.response.BaseResponse;
import com.mchekhashvili.rental.enums.EquipmentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstructionEquipmentItemResponse extends BaseResponse {
    private EquipmentType equipmentType;
    private String manufacturer;
}