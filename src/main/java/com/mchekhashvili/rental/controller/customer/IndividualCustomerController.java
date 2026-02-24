package com.mchekhashvili.rental.controller.customer;

import com.mchekhashvili.rental.dto.request.customer.IndividualCustomerRequest;
import com.mchekhashvili.rental.dto.response.customer.IndividualCustomerResponse;
import com.mchekhashvili.rental.model.customer.IndividualCustomer;
import com.mchekhashvili.rental.service.customer.IndividualCustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/individual-customers")
public class IndividualCustomerController
        extends AbstractCustomerController<IndividualCustomer, IndividualCustomerRequest, IndividualCustomerResponse> {

    public IndividualCustomerController(IndividualCustomerService service) {
        super(service);
    }
}
