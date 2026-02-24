package com.mchekhashvili.rental.dto.response;

import com.mchekhashvili.rental.enums.ItemStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseItemResponse {
    private Long id;
    private Long branchId;
    private ItemStatus status;
}
