package com.mchekhashvili.rental.dto.request.branch;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Address is required")
    private String address;

    @Email(message = "Email is not valid")
    private String email;

    private String phone;
}