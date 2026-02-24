package com.mchekhashvili.rental.controller.customer;

import com.mchekhashvili.rental.dto.request.customer.CorporateCustomerRequest;
import com.mchekhashvili.rental.dto.response.customer.CorporateCustomerResponse;
import com.mchekhashvili.rental.model.customer.CorporateCustomer;
import com.mchekhashvili.rental.service.customer.CorporateCustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/corporate-customers")
public class CorporateCustomerController
        extends AbstractCustomerController<CorporateCustomer, CorporateCustomerRequest, CorporateCustomerResponse> {

    public CorporateCustomerController(CorporateCustomerService service) {
        super(service);
    }
}
