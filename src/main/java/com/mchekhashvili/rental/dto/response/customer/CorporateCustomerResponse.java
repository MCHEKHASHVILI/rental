package com.mchekhashvili.rental.dto.response.customer;

import com.mchekhashvili.rental.dto.response.BaseEntityResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorporateCustomerResponse extends BaseEntityResponse {
    private String companyName;
    private String registrationNumber;
    private String contactPersonName;
    private String email;
    private String phone;
    private String address;
    private Long identificationDocumentId;
}
