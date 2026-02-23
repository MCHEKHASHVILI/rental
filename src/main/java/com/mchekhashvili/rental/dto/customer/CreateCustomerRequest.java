package com.mchekhashvili.rental.dto.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateCustomerRequest {

    private Long id;

    @Size(min=2, max=255)
    @NotNull(message="name field is required")
    @NotBlank(message="name field is required")
    private String name;

    private String surname;

    @Size(min=2, max=255)
    @NotNull(message="identificationDocument field is required")
    @NotBlank(message="identificationDocument field is required")
    private String identificationDocument;

    @Size(min=2, max=255)
    @NotNull(message="contactInformation field is required")
    @NotBlank(message="contactInformation field is required")
    private String contactInformation;

}
