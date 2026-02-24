package com.mchekhashvili.rental.mapper.rental;

import com.mchekhashvili.rental.dto.request.rental.ElectronicDeviceRentalRequest;
import com.mchekhashvili.rental.dto.response.rental.ElectronicDeviceRentalResponse;
import com.mchekhashvili.rental.model.rental.ElectronicDeviceRental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ElectronicDeviceRentalMapper extends RentalMapper<ElectronicDeviceRental, ElectronicDeviceRentalRequest, ElectronicDeviceRentalResponse> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rentedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "statusHistory", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "branch", ignore = true)
    @Mapping(target = "rentalItem", ignore = true)
    ElectronicDeviceRental toEntity(ElectronicDeviceRentalRequest request);

    @Override
    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "branchId", source = "branch.id")
    @Mapping(target = "rentalItemId", source = "rentalItem.id")
    ElectronicDeviceRentalResponse toResponse(ElectronicDeviceRental entity);
}