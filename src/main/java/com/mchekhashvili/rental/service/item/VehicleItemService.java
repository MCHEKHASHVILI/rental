package com.mchekhashvili.rental.service.item;

import com.mchekhashvili.rental.dto.request.item.VehicleItemRequest;
import com.mchekhashvili.rental.dto.response.item.VehicleItemResponse;
import com.mchekhashvili.rental.mapper.item.VehicleItemMapper;
import com.mchekhashvili.rental.model.item.VehicleItem;
import com.mchekhashvili.rental.repository.branch.BranchRepository;
import com.mchekhashvili.rental.repository.item.VehicleItemRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleItemService extends AbstractRentalItemService<VehicleItem, VehicleItemRequest, VehicleItemResponse> {

    public VehicleItemService(VehicleItemRepository repository, VehicleItemMapper mapper, BranchRepository branchRepository) {
        super(repository, mapper, branchRepository);
    }

    @Override
    protected Long getBranchId(VehicleItemRequest request) {
        return request.getBranchId();
    }

    @Override
    protected void updateFields(VehicleItem existing, VehicleItemRequest request) {
        mapper.updateEntity(request, existing);
    }
}
