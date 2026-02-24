package com.mchekhashvili.rental.controller.rental;

import com.mchekhashvili.rental.dto.request.rental.ElectronicDeviceRentalRequest;
import com.mchekhashvili.rental.dto.response.rental.ElectronicDeviceRentalResponse;
import com.mchekhashvili.rental.model.rental.ElectronicDeviceRental;
import com.mchekhashvili.rental.service.rental.ElectronicDeviceRentalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/electronic-device-rentals")
public class ElectronicDeviceRentalController
        extends AbstractRentalController<ElectronicDeviceRental, ElectronicDeviceRentalRequest, ElectronicDeviceRentalResponse> {

    public ElectronicDeviceRentalController(ElectronicDeviceRentalService service) {
        super(service);
    }
}
