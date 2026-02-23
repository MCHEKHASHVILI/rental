package com.mchekhashvili.rental.service.item;

import com.mchekhashvili.rental.enums.RentalStatus;
import com.mchekhashvili.rental.mapper.item.RentalItemMapper;
import com.mchekhashvili.rental.model.item.RentalItem;
import com.mchekhashvili.rental.repository.item.RentalItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractRentalItemService<E extends RentalItem, RQ, RS> implements RentalItemService<E, RQ, RS> {

    protected final RentalItemRepository<E> repository;
    protected final RentalItemMapper<E, RQ, RS> mapper;

    @Override
    public List<RS> findAll() {
        return repository.findAll()
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
        updateFields(existing, request);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        E item = findEntityById(id);
        item.setStatus(RentalStatus.LOST);
        repository.save(item);
    }

    protected E findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + id));
    }

    protected abstract void updateFields(E existing, RQ request);
}