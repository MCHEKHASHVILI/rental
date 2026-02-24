package com.mchekhashvili.rental.mapper.customer;

import com.mchekhashvili.rental.dto.request.customer.IndividualCustomerRequest;
import com.mchekhashvili.rental.dto.response.customer.IndividualCustomerResponse;
import com.mchekhashvili.rental.model.customer.IndividualCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IndividualCustomerMapper extends CustomerMapper<IndividualCustomer, IndividualCustomerRequest, IndividualCustomerResponse> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "identificationDocument", ignore = true)
    IndividualCustomer toEntity(IndividualCustomerRequest request);

    @Override
    @Mapping(target = "identificationDocumentId", source = "identificationDocument.id")
    IndividualCustomerResponse toResponse(IndividualCustomer entity);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "identificationDocument", ignore = true)
    void updateEntity(IndividualCustomerRequest request, @MappingTarget IndividualCustomer entity);
}