package com.mchekhashvili.rental.service.rental;

import com.mchekhashvili.rental.dto.request.rental.RentalStatusUpdateRequest;
import com.mchekhashvili.rental.enums.ItemStatus;
import com.mchekhashvili.rental.enums.RentalStatus;
import com.mchekhashvili.rental.mapper.rental.RentalMapper;
import com.mchekhashvili.rental.model.branch.Branch;
import com.mchekhashvili.rental.model.customer.Customer;
import com.mchekhashvili.rental.model.item.RentalItem;
import com.mchekhashvili.rental.model.rental.Rental;
import com.mchekhashvili.rental.model.rental.RentalStatusHistory;
import com.mchekhashvili.rental.repository.branch.BranchRepository;
import com.mchekhashvili.rental.repository.customer.BaseCustomerRepository;
import com.mchekhashvili.rental.repository.item.BaseRentalItemRepository;
import com.mchekhashvili.rental.repository.rental.RentalRepository;
import com.mchekhashvili.rental.repository.rental.RentalStatusHistoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractRentalService<E extends Rental, RQ, RS> implements RentalService<E, RQ, RS> {

    protected final RentalRepository<E> repository;
    protected final RentalMapper<E, RQ, RS> mapper;
    protected final BaseRentalItemRepository rentalItemRepository;
    protected final BaseCustomerRepository customerRepository;
    protected final BranchRepository branchRepository;
    protected final RentalStatusHistoryRepository statusHistoryRepository;

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
        Long itemId = getRentalItemId(request);
        RentalItem item = rentalItemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + itemId));

        validateItemType(item);

        if (item.getStatus() != ItemStatus.AVAILABLE) {
            throw new IllegalStateException("Item is not available for rent, current status: " + item.getStatus());
        }

        Long customerId = getCustomerId(request);
        Customer customer = customerRepository.findByIdAndActiveTrue(customerId)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + customerId));

        Long branchId = getBranchId(request);
        Branch branch = branchRepository.findByIdAndActiveTrue(branchId)
                .orElseThrow(() -> new EntityNotFoundException("Branch not found with id: " + branchId));

        E entity = mapper.toEntity(request);
        entity.setRentedAt(LocalDateTime.now());
        entity.setStatus(RentalStatus.RENTED);
        entity.setCustomer(customer);
        entity.setBranch(branch);
        entity.setRentalItem(item);

        item.setStatus(ItemStatus.RENTED);
        rentalItemRepository.save(item);

        E saved = repository.save(entity);
        appendHistory(saved, RentalStatus.RENTED, "Rental created");

        return mapper.toResponse(saved);
    }

    @Override
    public RS updateStatus(Long id, RentalStatusUpdateRequest request) {
        E rental = findEntityById(id);
        RentalStatus current = rental.getStatus();
        RentalStatus target = request.getStatus();

        if (!current.canTransitionTo(target)) {
            throw new IllegalStateException(
                    "Cannot transition rental status from " + current + " to " + target);
        }

        rental.setStatus(target);

        RentalItem item = rental.getRentalItem();
        if (target == RentalStatus.RETURNED) {
            item.setStatus(ItemStatus.AVAILABLE);
        } else if (target == RentalStatus.DAMAGED) {
            item.setStatus(ItemStatus.DAMAGED);
        } else if (target == RentalStatus.LOST) {
            item.setStatus(ItemStatus.LOST);
        }
        rentalItemRepository.save(item);

        E saved = repository.save(rental);
        appendHistory(saved, target, request.getReason());

        return mapper.toResponse(saved);
    }

    @Override
    public void delete(Long id) {
        E rental = findEntityById(id);
        if (!rental.getStatus().canTransitionTo(RentalStatus.RETURNED)) {
            throw new IllegalStateException(
                    "Cannot cancel rental with status: " + rental.getStatus());
        }
        rental.setStatus(RentalStatus.RETURNED);

        RentalItem item = rental.getRentalItem();
        item.setStatus(ItemStatus.AVAILABLE);
        rentalItemRepository.save(item);

        E saved = repository.save(rental);
        appendHistory(saved, RentalStatus.RETURNED, "Rental cancelled");
    }

    protected E findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rental not found with id: " + id));
    }

    private void appendHistory(E rental, RentalStatus status, String reason) {
        RentalStatusHistory history = new RentalStatusHistory();
        history.setRental(rental);
        history.setStatus(status);
        history.setChangedAt(LocalDateTime.now());
        history.setReason(reason);
        statusHistoryRepository.save(history);
    }

    protected abstract Long getRentalItemId(RQ request);
    protected abstract Long getCustomerId(RQ request);
    protected abstract Long getBranchId(RQ request);
    protected abstract void validateItemType(RentalItem item);
}
