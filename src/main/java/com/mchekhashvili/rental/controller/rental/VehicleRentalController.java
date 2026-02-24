package com.mchekhashvili.rental.controller.rental;

import com.mchekhashvili.rental.dto.request.rental.VehicleRentalRequest;
import com.mchekhashvili.rental.dto.response.rental.VehicleRentalResponse;
import com.mchekhashvili.rental.model.rental.VehicleRental;
import com.mchekhashvili.rental.service.rental.VehicleRentalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle-rentals")
public class VehicleRentalController
        extends AbstractRentalController<VehicleRental, VehicleRentalRequest, VehicleRentalResponse> {

    public VehicleRentalController(VehicleRentalService service) {
        super(service);
    }
}
