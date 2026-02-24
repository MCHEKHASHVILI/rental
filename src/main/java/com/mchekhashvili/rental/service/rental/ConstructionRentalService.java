package com.mchekhashvili.rental.service.rental;

import com.mchekhashvili.rental.dto.request.rental.ConstructionRentalRequest;
import com.mchekhashvili.rental.dto.response.rental.ConstructionRentalResponse;
import com.mchekhashvili.rental.mapper.rental.ConstructionRentalMapper;
import com.mchekhashvili.rental.model.customer.Customer;
import com.mchekhashvili.rental.model.item.ConstructionEquipmentItem;
import com.mchekhashvili.rental.model.item.RentalItem;
import com.mchekhashvili.rental.model.rental.ConstructionRental;
import com.mchekhashvili.rental.repository.branch.BranchRepository;
import com.mchekhashvili.rental.repository.customer.CustomerRepository;
import com.mchekhashvili.rental.repository.item.RentalItemRepository;
import com.mchekhashvili.rental.repository.rental.ConstructionRentalRepository;
import com.mchekhashvili.rental.repository.rental.RentalStatusHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ConstructionRentalService extends AbstractRentalService<ConstructionRental, ConstructionRentalRequest, ConstructionRentalResponse> {

    public ConstructionRentalService(
            ConstructionRentalRepository repository,
            ConstructionRentalMapper mapper,
            RentalItemRepository<RentalItem> rentalItemRepository,
            CustomerRepository<Customer> customerRepository,
            BranchRepository branchRepository,
            RentalStatusHistoryRepository statusHistoryRepository) {
        super(repository, mapper, rentalItemRepository, customerRepository, branchRepository, statusHistoryRepository);
    }

    @Override
    protected Long getRentalItemId(ConstructionRentalRequest request) {
        return request.getRentalItemId();
    }

    @Override
    protected Long getCustomerId(ConstructionRentalRequest request) {
        return request.getCustomerId();
    }

    @Override
    protected Long getBranchId(ConstructionRentalRequest request) {
        return request.getBranchId();
    }

    @Override
    protected void validateItemType(RentalItem item) {
        if (!(item instanceof ConstructionEquipmentItem)) {
            throw new IllegalArgumentException("Item is not a construction equipment");
        }
    }
}
