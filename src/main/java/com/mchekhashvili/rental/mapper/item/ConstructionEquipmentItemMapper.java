package com.mchekhashvili.rental.mapper.item;

import com.mchekhashvili.rental.dto.request.item.ConstructionEquipmentItemRequest;
import com.mchekhashvili.rental.dto.response.item.ConstructionEquipmentItemResponse;
import com.mchekhashvili.rental.model.item.ConstructionEquipmentItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ConstructionEquipmentItemMapper extends RentalItemMapper<ConstructionEquipmentItem, ConstructionEquipmentItemRequest, ConstructionEquipmentItemResponse> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "rentals", ignore = true)
    @Mapping(target = "branch", ignore = true)
    ConstructionEquipmentItem toEntity(ConstructionEquipmentItemRequest request);

    @Override
    @Mapping(target = "branchId", source = "branch.id")
    ConstructionEquipmentItemResponse toResponse(ConstructionEquipmentItem entity);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "rentals", ignore = true)
    @Mapping(target = "branch", ignore = true)
    void updateEntity(ConstructionEquipmentItemRequest request, @MappingTarget ConstructionEquipmentItem entity);
}
