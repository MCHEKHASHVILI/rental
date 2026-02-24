package com.mchekhashvili.rental.dto.response;

import com.mchekhashvili.rental.enums.ItemStatus;
import lombok.Getter;
import lombok.Setter;

/**
 * Base for rental item response DTOs — carries the item availability status.
 * id and branchId are inherited from BaseEntityResponse.
 */
@Getter
@Setter
public abstract class BaseItemResponse extends BaseEntityResponse {
    private ItemStatus status;
}
