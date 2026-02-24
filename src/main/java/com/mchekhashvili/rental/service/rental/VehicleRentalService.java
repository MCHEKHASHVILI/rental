package com.mchekhashvili.rental.service.rental;

import com.mchekhashvili.rental.dto.request.rental.VehicleRentalRequest;
import com.mchekhashvili.rental.dto.response.rental.VehicleRentalResponse;
import com.mchekhashvili.rental.mapper.rental.VehicleRentalMapper;
import com.mchekhashvili.rental.model.item.RentalItem;
import com.mchekhashvili.rental.model.item.VehicleItem;
import com.mchekhashvili.rental.model.rental.VehicleRental;
import com.mchekhashvili.rental.repository.branch.BranchRepository;
import com.mchekhashvili.rental.repository.customer.BaseCustomerRepository;
import com.mchekhashvili.rental.repository.item.BaseRentalItemRepository;
import com.mchekhashvili.rental.repository.rental.RentalStatusHistoryRepository;
import com.mchekhashvili.rental.repository.rental.VehicleRentalRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleRentalService extends AbstractRentalService<VehicleRental, VehicleRentalRequest, VehicleRentalResponse> {

    public VehicleRentalService(
            VehicleRentalRepository repository,
            VehicleRentalMapper mapper,
            BaseRentalItemRepository rentalItemRepository,
            BaseCustomerRepository customerRepository,
            BranchRepository branchRepository,
            RentalStatusHistoryRepository statusHistoryRepository) {
        super(repository, mapper, rentalItemRepository, customerRepository, branchRepository, statusHistoryRepository);
    }

    @Override
    protected Long getRentalItemId(VehicleRentalRequest request) {
        return request.getRentalItemId();
    }

    @Override
    protected Long getCustomerId(VehicleRentalRequest request) {
        return request.getCustomerId();
    }

    @Override
    protected Long getBranchId(VehicleRentalRequest request) {
        return request.getBranchId();
    }

    @Override
    protected void validateItemType(RentalItem item) {
        if (!(item instanceof VehicleItem)) {
            throw new IllegalArgumentException("Item is not a vehicle");
        }
    }
}
