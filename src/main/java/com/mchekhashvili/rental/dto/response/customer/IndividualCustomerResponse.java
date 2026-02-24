package com.mchekhashvili.rental.dto.response.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IndividualCustomerResponse extends BaseCustomerResponse {
    private String firstName;
    private String lastName;
}
