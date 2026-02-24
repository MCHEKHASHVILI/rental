package com.mchekhashvili.rental.mapper.rental;

import com.mchekhashvili.rental.dto.request.rental.VehicleRentalRequest;
import com.mchekhashvili.rental.dto.response.rental.VehicleRentalResponse;
import com.mchekhashvili.rental.model.rental.VehicleRental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VehicleRentalMapper extends RentalMapper<VehicleRental, VehicleRentalRequest, VehicleRentalResponse> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rentedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "statusHistory", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "branch", ignore = true)
    @Mapping(target = "rentalItem", ignore = true)
    VehicleRental toEntity(VehicleRentalRequest request);

    @Override
    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "branchId", source = "branch.id")
    @Mapping(target = "rentalItemId", source = "rentalItem.id")
    VehicleRentalResponse toResponse(VehicleRental entity);
}