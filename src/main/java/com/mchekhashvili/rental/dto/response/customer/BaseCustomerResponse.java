package com.mchekhashvili.rental.dto.response.customer;

import com.mchekhashvili.rental.dto.response.BaseResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * Base for all customer response DTOs.
 * Holds fields common to both individual and corporate customers.
 */
@Getter
@Setter
public abstract class BaseCustomerResponse extends BaseResponse {
    private String email;
    private String phone;
    private String address;
    private Long identificationDocumentId;
}
