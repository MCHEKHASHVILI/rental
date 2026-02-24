package com.mchekhashvili.rental.service.rental;

import com.mchekhashvili.rental.dto.request.rental.ElectronicDeviceRentalRequest;
import com.mchekhashvili.rental.dto.response.rental.ElectronicDeviceRentalResponse;
import com.mchekhashvili.rental.mapper.rental.ElectronicDeviceRentalMapper;
import com.mchekhashvili.rental.model.item.ElectronicDeviceItem;
import com.mchekhashvili.rental.model.item.RentalItem;
import com.mchekhashvili.rental.model.rental.ElectronicDeviceRental;
import com.mchekhashvili.rental.repository.branch.BranchRepository;
import com.mchekhashvili.rental.repository.customer.BaseCustomerRepository;
import com.mchekhashvili.rental.repository.item.BaseRentalItemRepository;
import com.mchekhashvili.rental.repository.rental.ElectronicDeviceRentalRepository;
import com.mchekhashvili.rental.repository.rental.RentalStatusHistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ElectronicDeviceRentalService extends AbstractRentalService<ElectronicDeviceRental, ElectronicDeviceRentalRequest, ElectronicDeviceRentalResponse> {

    public ElectronicDeviceRentalService(
            ElectronicDeviceRentalRepository repository,
            ElectronicDeviceRentalMapper mapper,
            BaseRentalItemRepository rentalItemRepository,
            BaseCustomerRepository customerRepository,
            BranchRepository branchRepository,
            RentalStatusHistoryRepository statusHistoryRepository) {
        super(repository, mapper, rentalItemRepository, customerRepository, branchRepository, statusHistoryRepository);
    }

    @Override
    protected Long getRentalItemId(ElectronicDeviceRentalRequest request) {
        return request.getRentalItemId();
    }

    @Override
    protected Long getCustomerId(ElectronicDeviceRentalRequest request) {
        return request.getCustomerId();
    }

    @Override
    protected Long getBranchId(ElectronicDeviceRentalRequest request) {
        return request.getBranchId();
    }

    @Override
    protected void validateItemType(RentalItem item) {
        if (!(item instanceof ElectronicDeviceItem)) {
            throw new IllegalArgumentException("Item is not an electronic device");
        }
    }
}
