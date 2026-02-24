package com.mchekhashvili.rental.service.customer;

import com.mchekhashvili.rental.mapper.customer.CustomerMapper;
import com.mchekhashvili.rental.model.customer.Customer;
import com.mchekhashvili.rental.model.customer.document.IdentificationDocument;
import com.mchekhashvili.rental.repository.customer.CustomerRepository;
import com.mchekhashvili.rental.repository.customer.IdentificationDocumentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractCustomerService<E extends Customer, RQ, RS> implements CustomerService<E, RQ, RS> {

    protected final CustomerRepository<E> repository;
    protected final CustomerMapper<E, RQ, RS> mapper;
    protected final IdentificationDocumentRepository identificationDocumentRepository;

    @Override
    public List<RS> findAll() {
        return repository.findAllByActiveTrue()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<RS> findAllDeleted() {
        return repository.findAllByActiveFalse()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public RS findById(Long id) {
        return mapper.toResponse(findActiveEntityById(id));
    }

    @Override
    public RS save(RQ request) {
        E entity = mapper.toEntity(request);
        IdentificationDocument document = identificationDocumentRepository
                .findById(getIdentificationDocumentId(request))
                .orElseThrow(() -> new EntityNotFoundException("Identification document not found"));
        entity.setIdentificationDocument(document);
        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public RS update(Long id, RQ request) {
        E existing = findActiveEntityById(id);
        mapper.updateEntity(request, existing);
        IdentificationDocument document = identificationDocumentRepository
                .findById(getIdentificationDocumentId(request))
                .orElseThrow(() -> new EntityNotFoundException("Identification document not found"));
        existing.setIdentificationDocument(document);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        E existing = findActiveEntityById(id);
        existing.setActive(false);
        repository.save(existing);
    }

    @Override
    public RS restore(Long id) {
        E existing = repository.findByIdAndActiveFalse(id)
                .orElseThrow(() -> new EntityNotFoundException("Deleted customer not found with id: " + id));
        existing.setActive(true);
        return mapper.toResponse(repository.save(existing));
    }

    protected E findActiveEntityById(Long id) {
        return repository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
    }

    protected abstract Long getIdentificationDocumentId(RQ request);
}
