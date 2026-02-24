package com.mchekhashvili.rental.controller.item;

import com.mchekhashvili.rental.dto.request.item.ConstructionEquipmentItemRequest;
import com.mchekhashvili.rental.dto.response.item.ConstructionEquipmentItemResponse;
import com.mchekhashvili.rental.model.item.ConstructionEquipmentItem;
import com.mchekhashvili.rental.service.item.ConstructionEquipmentItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/construction-equipment")
public class ConstructionEquipmentItemController
        extends AbstractRentalItemController<ConstructionEquipmentItem, ConstructionEquipmentItemRequest, ConstructionEquipmentItemResponse> {

    public ConstructionEquipmentItemController(ConstructionEquipmentItemService service) {
        super(service);
    }
}
