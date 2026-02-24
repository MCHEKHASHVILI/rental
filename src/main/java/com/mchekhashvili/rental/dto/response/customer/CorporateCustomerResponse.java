package com.mchekhashvili.rental.dto.response.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorporateCustomerResponse extends BaseCustomerResponse {
    private String companyName;
    private String registrationNumber;
    private String contactPersonName;
}
