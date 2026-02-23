package com.mchekhashvili.rental.service;

import com.mchekhashvili.rental.dto.customer.CreateCustomerRequest;
import com.mchekhashvili.rental.dto.customer.CustomerDto;
import com.mchekhashvili.rental.mapper.CustomerMapper;
import com.mchekhashvili.rental.model.Customer;
import com.mchekhashvili.rental.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerDto create(@Valid CreateCustomerRequest request) {
        Customer customer = customerMapper.createCustomerRequestToCustomer(request);

        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.customerToCustomerDto(savedCustomer);
    }

    @Cacheable("customers")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        return customerMapper.customerToCustomerDto(customer);
    }
}