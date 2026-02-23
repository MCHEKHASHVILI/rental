package com.mchekhashvili.rental.mapper.item;

import com.mchekhashvili.rental.dto.request.item.VehicleItemRequest;
import com.mchekhashvili.rental.dto.response.item.VehicleItemResponse;
import com.mchekhashvili.rental.model.item.VehicleItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleItemMapper extends RentalItemMapper<VehicleItem, VehicleItemRequest, VehicleItemResponse> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "rentals", ignore = true)
    @Mapping(target = "branch.id", source = "branchId")
    VehicleItem toEntity(VehicleItemRequest request);

    @Override
    @Mapping(target = "branchId", source = "branch.id")
    VehicleItemResponse toResponse(VehicleItem entity);
}