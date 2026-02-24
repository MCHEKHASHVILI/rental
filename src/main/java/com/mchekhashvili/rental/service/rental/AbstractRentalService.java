package com.mchekhashvili.rental.service.rental;

import com.mchekhashvili.rental.enums.RentalStatus;
import com.mchekhashvili.rental.mapper.rental.RentalMapper;
import com.mchekhashvili.rental.model.branch.Branch;
import com.mchekhashvili.rental.model.customer.Customer;
import com.mchekhashvili.rental.model.item.RentalItem;
import com.mchekhashvili.rental.model.rental.Rental;
import com.mchekhashvili.rental.repository.branch.BranchRepository;
import com.mchekhashvili.rental.repository.customer.CustomerRepository;
import com.mchekhashvili.rental.repository.item.RentalItemRepository;
import com.mchekhashvili.rental.repository.rental.RentalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractRentalService<E extends Rental, RQ, RS> implements RentalService<E, RQ, RS> {

    protected final RentalRepository<E> repository;
    protected final RentalMapper<E, RQ, RS> mapper;
    protected final RentalItemRepository<RentalItem> rentalItemRepository;
    protected final CustomerRepository<Customer> customerRepository;
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
        Long itemId = getRentalItemId(request);
        RentalItem item = rentalItemRepository.findById(itemId)
                .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + itemId));

        validateItemType(item);

        if (item.getStatus() != RentalStatus.AVAILABLE) {
            throw new IllegalStateException("Item is not available for rent");
        }

        Customer customer = customerRepository.findById(getCustomerId(request))
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + getCustomerId(request)));

        Branch branch = branchRepository.findById(getBranchId(request))
                .orElseThrow(() -> new EntityNotFoundException("Branch not found with id: " + getBranchId(request)));

        E entity = mapper.toEntity(request);
        entity.setRentedAt(LocalDateTime.now());
        entity.setStatus(RentalStatus.RENTED);
        entity.setCustomer(customer);
        entity.setBranch(branch);
        entity.setRentalItem(item);

        item.setStatus(RentalStatus.RENTED);
        rentalItemRepository.save(item);

        return mapper.toResponse(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        E rental = findEntityById(id);
        if (rental.getStatus() == RentalStatus.RETURNED || rental.getStatus() == RentalStatus.LOST) {
            throw new IllegalStateException("Cannot cancel a completed or lost rental");
        }
        rental.setStatus(RentalStatus.RETURNED);
        repository.save(rental);

        RentalItem item = rental.getRentalItem();
        item.setStatus(RentalStatus.AVAILABLE);
        rentalItemRepository.save(item);
    }

    protected E findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rental not found with id: " + id));
    }

    protected abstract Long getRentalItemId(RQ request);
    protected abstract Long getCustomerId(RQ request);
    protected abstract Long getBranchId(RQ request);
    protected abstract void validateItemType(RentalItem item);

}