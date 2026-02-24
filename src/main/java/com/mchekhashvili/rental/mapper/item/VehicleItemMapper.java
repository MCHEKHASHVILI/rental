package com.mchekhashvili.rental.mapper.item;

import com.mchekhashvili.rental.dto.request.item.VehicleItemRequest;
import com.mchekhashvili.rental.dto.response.item.VehicleItemResponse;
import com.mchekhashvili.rental.model.item.VehicleItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VehicleItemMapper extends RentalItemMapper<VehicleItem, VehicleItemRequest, VehicleItemResponse> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "rentals", ignore = true)
    @Mapping(target = "branch", ignore = true)
    VehicleItem toEntity(VehicleItemRequest request);

    @Override
    @Mapping(target = "branchId", source = "branch.id")
    VehicleItemResponse toResponse(VehicleItem entity);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "rentals", ignore = true)
    @Mapping(target = "branch", ignore = true)
    void updateEntity(VehicleItemRequest request, @MappingTarget VehicleItem entity);
}
