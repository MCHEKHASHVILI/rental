package com.mchekhashvili.rental.service.customer;

import com.mchekhashvili.rental.dto.request.customer.IndividualCustomerRequest;
import com.mchekhashvili.rental.dto.response.customer.IndividualCustomerResponse;
import com.mchekhashvili.rental.mapper.customer.IndividualCustomerMapper;
import com.mchekhashvili.rental.model.customer.IndividualCustomer;
import com.mchekhashvili.rental.repository.customer.IndividualCustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class IndividualCustomerService extends AbstractCustomerService<IndividualCustomer, IndividualCustomerRequest, IndividualCustomerResponse> {

    public IndividualCustomerService(IndividualCustomerRepository repository, IndividualCustomerMapper mapper) {
        super(repository, mapper);
    }
}