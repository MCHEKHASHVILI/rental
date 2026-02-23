package com.mchekhashvili.rental.dto.response.branch;

import com.mchekhashvili.rental.dto.response.BaseResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BranchResponse extends BaseResponse {
    private String name;
    private String address;
    private String email;
    private String phone;
    private boolean active;
}