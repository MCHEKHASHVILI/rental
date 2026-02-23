package com.mchekhashvili.rental.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String fullName;
    private String identificationDocument;
    private String contactInformation;
}
