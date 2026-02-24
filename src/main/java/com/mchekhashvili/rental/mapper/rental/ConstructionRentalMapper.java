package com.mchekhashvili.rental.mapper.rental;

import com.mchekhashvili.rental.dto.request.rental.ConstructionRentalRequest;
import com.mchekhashvili.rental.dto.response.rental.ConstructionRentalResponse;
import com.mchekhashvili.rental.model.rental.ConstructionRental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConstructionRentalMapper extends RentalMapper<ConstructionRental, ConstructionRentalRequest, ConstructionRentalResponse> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rentedAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "statusHistory", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "branch", ignore = true)
    @Mapping(target = "rentalItem", ignore = true)
    ConstructionRental toEntity(ConstructionRentalRequest request);

    @Override
    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "branchId", source = "branch.id")
    @Mapping(target = "rentalItemId", source = "rentalItem.id")
    ConstructionRentalResponse toResponse(ConstructionRental entity);
}