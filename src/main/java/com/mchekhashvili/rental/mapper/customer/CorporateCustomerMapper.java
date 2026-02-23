package com.mchekhashvili.rental.mapper.customer;

import com.mchekhashvili.rental.dto.request.customer.CorporateCustomerRequest;
import com.mchekhashvili.rental.dto.response.customer.CorporateCustomerResponse;
import com.mchekhashvili.rental.model.customer.CorporateCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CorporateCustomerMapper extends CustomerMapper<CorporateCustomer, CorporateCustomerRequest, CorporateCustomerResponse> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "identificationDocument.id", source = "identificationDocumentId")
    CorporateCustomer toEntity(CorporateCustomerRequest request);

    @Override
    @Mapping(target = "identificationDocumentId", source = "identificationDocument.id")
    CorporateCustomerResponse toResponse(CorporateCustomer entity);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "identificationDocument.id", source = "identificationDocumentId")
    void updateEntity(CorporateCustomerRequest request, @MappingTarget CorporateCustomer entity);
}