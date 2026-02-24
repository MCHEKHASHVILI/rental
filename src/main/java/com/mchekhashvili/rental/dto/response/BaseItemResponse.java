package com.mchekhashvili.rental.dto.response;

import com.mchekhashvili.rental.enums.ItemStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * Base for rental item response DTOs — carries branchId and item availability status.
 */
@Getter
@Setter
public abstract class BaseItemResponse extends BaseResponse {
    private Long branchId;
    private ItemStatus status;
}
