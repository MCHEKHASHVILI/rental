package com.mchekhashvili.rental.service.item;

import com.mchekhashvili.rental.dto.request.item.VehicleItemRequest;
import com.mchekhashvili.rental.dto.response.item.VehicleItemResponse;
import com.mchekhashvili.rental.mapper.item.VehicleItemMapper;
import com.mchekhashvili.rental.model.item.VehicleItem;
import com.mchekhashvili.rental.repository.item.VehicleItemRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleItemService extends AbstractRentalItemService<VehicleItem, VehicleItemRequest, VehicleItemResponse> {

    public VehicleItemService(VehicleItemRepository repository, VehicleItemMapper mapper) {
        super(repository, mapper);
    }

    @Override
    protected void updateFields(VehicleItem existing, VehicleItemRequest request) {
        existing.setMake(request.getMake());
        existing.setModel(request.getModel());
        existing.setYearOfManufacture(request.getYearOfManufacture());
    }
}