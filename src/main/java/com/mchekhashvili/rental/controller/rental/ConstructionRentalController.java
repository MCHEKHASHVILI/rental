package com.mchekhashvili.rental.controller.rental;

import com.mchekhashvili.rental.dto.request.rental.ConstructionRentalRequest;
import com.mchekhashvili.rental.dto.response.rental.ConstructionRentalResponse;
import com.mchekhashvili.rental.model.rental.ConstructionRental;
import com.mchekhashvili.rental.service.rental.ConstructionRentalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/construction-rentals")
public class ConstructionRentalController
        extends AbstractRentalController<ConstructionRental, ConstructionRentalRequest, ConstructionRentalResponse> {

    public ConstructionRentalController(ConstructionRentalService service) {
        super(service);
    }
}
