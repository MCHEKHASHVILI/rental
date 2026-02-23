package com.mchekhashvili.rental.dto.request.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorporateCustomerRequest {

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Registration number is required")
    private String registrationNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email is not valid")
    private String email;

    @NotNull(message = "Identification document is required")
    private Long identificationDocumentId;

    private String contactPersonName;
    private String phone;
    private String address;
}