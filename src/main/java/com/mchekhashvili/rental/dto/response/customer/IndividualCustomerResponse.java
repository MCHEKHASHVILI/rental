package com.mchekhashvili.rental.dto.response.customer;

import com.mchekhashvili.rental.dto.response.BaseEntityResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IndividualCustomerResponse extends BaseEntityResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Long identificationDocumentId;
}
