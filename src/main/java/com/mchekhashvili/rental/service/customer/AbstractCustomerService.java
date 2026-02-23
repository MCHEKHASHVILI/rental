package com.mchekhashvili.rental.service.customer;

import com.mchekhashvili.rental.mapper.customer.CustomerMapper;
import com.mchekhashvili.rental.model.customer.Customer;
import com.mchekhashvili.rental.repository.customer.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractCustomerService<E extends Customer, RQ, RS> implements CustomerService<E, RQ, RS> {

    protected final CustomerRepository<E> repository;
    protected final CustomerMapper<E, RQ, RS> mapper;

    @Override
    public List<RS> findAll() {
        return repository.findAllByActiveTrue()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public RS findById(Long id) {
        return mapper.toResponse(findEntityById(id));
    }

    @Override
    public RS save(RQ request) {
        E entity = mapper.toEntity(request);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public RS update(Long id, RQ request) {
        E existing = findEntityById(id);
        mapper.updateEntity(request, existing);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        E existing = findEntityById(id);
        existing.setActive(false);
        repository.save(existing);
    }

    protected E findEntityById(Long id) {
        return repository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
    }
}