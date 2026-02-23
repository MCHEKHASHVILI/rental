package com.mchekhashvili.rental.service.customer;

import com.mchekhashvili.rental.dto.request.customer.CorporateCustomerRequest;
import com.mchekhashvili.rental.dto.response.customer.CorporateCustomerResponse;
import com.mchekhashvili.rental.mapper.customer.CorporateCustomerMapper;
import com.mchekhashvili.rental.model.customer.CorporateCustomer;
import com.mchekhashvili.rental.repository.customer.CorporateCustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CorporateCustomerService extends AbstractCustomerService<CorporateCustomer, CorporateCustomerRequest, CorporateCustomerResponse> {

    public CorporateCustomerService(CorporateCustomerRepository repository, CorporateCustomerMapper mapper) {
        super(repository, mapper);
    }
}