package com.mchekhashvili.rental.controller.item;

import com.mchekhashvili.rental.dto.request.item.ElectronicDeviceItemRequest;
import com.mchekhashvili.rental.dto.response.item.ElectronicDeviceItemResponse;
import com.mchekhashvili.rental.model.item.ElectronicDeviceItem;
import com.mchekhashvili.rental.service.item.ElectronicDeviceItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/electronic-devices")
public class ElectronicDeviceItemController
        extends AbstractRentalItemController<ElectronicDeviceItem, ElectronicDeviceItemRequest, ElectronicDeviceItemResponse> {

    public ElectronicDeviceItemController(ElectronicDeviceItemService service) {
        super(service);
    }
}
