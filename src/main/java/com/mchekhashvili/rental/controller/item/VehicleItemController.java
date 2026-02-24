package com.mchekhashvili.rental.controller.item;

import com.mchekhashvili.rental.dto.request.item.VehicleItemRequest;
import com.mchekhashvili.rental.dto.response.item.VehicleItemResponse;
import com.mchekhashvili.rental.model.item.VehicleItem;
import com.mchekhashvili.rental.service.item.VehicleItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class VehicleItemController
        extends AbstractRentalItemController<VehicleItem, VehicleItemRequest, VehicleItemResponse> {

    public VehicleItemController(VehicleItemService service) {
        super(service);
    }
}
