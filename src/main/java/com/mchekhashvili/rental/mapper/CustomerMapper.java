package com.mchekhashvili.rental.mapper;

import com.mchekhashvili.rental.dto.customer.CreateCustomerRequest;
import com.mchekhashvili.rental.dto.customer.CustomerDto;
import com.mchekhashvili.rental.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target="fullName", expression = "java(String.join(\" \", request.getName(), request.getSurname()).trim())")
    Customer createCustomerRequestToCustomer(CreateCustomerRequest request);

    CustomerDto customerToCustomerDto(Customer customer);

}
