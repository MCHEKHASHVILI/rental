package com.mchekhashvili.rental.service.item;

import com.mchekhashvili.rental.enums.ItemStatus;
import com.mchekhashvili.rental.mapper.item.RentalItemMapper;
import com.mchekhashvili.rental.model.branch.Branch;
import com.mchekhashvili.rental.model.item.RentalItem;
import com.mchekhashvili.rental.repository.branch.BranchRepository;
import com.mchekhashvili.rental.repository.item.RentalItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractRentalItemService<E extends RentalItem, RQ, RS> implements RentalItemService<E, RQ, RS> {

    protected final RentalItemRepository<E> repository;
    protected final RentalItemMapper<E, RQ, RS> mapper;
    protected final BranchRepository branchRepository;

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
        Long branchId = getBranchId(request);
        Branch branch = branchRepository.findByIdAndActiveTrue(branchId)
                .orElseThrow(() -> new EntityNotFoundException("Branch not found with id: " + branchId));
        E entity = mapper.toEntity(request);
        entity.setBranch(branch);
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
        E item = findEntityById(id);
        if (!item.getStatus().canTransitionTo(ItemStatus.LOST)) {
            throw new IllegalStateException("Item with status " + item.getStatus() + " cannot be marked as LOST");
        }
        item.setStatus(ItemStatus.LOST);
        repository.save(item);
    }

    protected E findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + id));
    }

    protected abstract Long getBranchId(RQ request);
}
