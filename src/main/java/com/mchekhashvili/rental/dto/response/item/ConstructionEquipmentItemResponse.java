package com.mchekhashvili.rental.dto.response.item;

import com.mchekhashvili.rental.dto.response.BaseItemResponse;
import com.mchekhashvili.rental.enums.EquipmentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstructionEquipmentItemResponse extends BaseItemResponse {
    private EquipmentType equipmentType;
    private String manufacturer;
}
