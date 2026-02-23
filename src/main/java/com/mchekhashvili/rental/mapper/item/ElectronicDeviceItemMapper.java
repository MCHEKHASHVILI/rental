package com.mchekhashvili.rental.mapper.item;

import com.mchekhashvili.rental.dto.request.item.ElectronicDeviceItemRequest;
import com.mchekhashvili.rental.dto.response.item.ElectronicDeviceItemResponse;
import com.mchekhashvili.rental.model.item.ElectronicDeviceItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ElectronicDeviceItemMapper extends RentalItemMapper<ElectronicDeviceItem, ElectronicDeviceItemRequest, ElectronicDeviceItemResponse> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "rentals", ignore = true)
    @Mapping(target = "branch.id", source = "branchId")
    ElectronicDeviceItem toEntity(ElectronicDeviceItemRequest request);

    @Override
    @Mapping(target = "branchId", source = "branch.id")
    ElectronicDeviceItemResponse toResponse(ElectronicDeviceItem entity);
}