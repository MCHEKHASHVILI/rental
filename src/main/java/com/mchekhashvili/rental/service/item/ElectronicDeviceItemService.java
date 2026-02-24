package com.mchekhashvili.rental.service.item;

import com.mchekhashvili.rental.dto.request.item.ElectronicDeviceItemRequest;
import com.mchekhashvili.rental.dto.response.item.ElectronicDeviceItemResponse;
import com.mchekhashvili.rental.mapper.item.ElectronicDeviceItemMapper;
import com.mchekhashvili.rental.model.item.ElectronicDeviceItem;
import com.mchekhashvili.rental.repository.branch.BranchRepository;
import com.mchekhashvili.rental.repository.item.ElectronicDeviceItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ElectronicDeviceItemService extends AbstractRentalItemService<ElectronicDeviceItem, ElectronicDeviceItemRequest, ElectronicDeviceItemResponse> {

    public ElectronicDeviceItemService(ElectronicDeviceItemRepository repository, ElectronicDeviceItemMapper mapper, BranchRepository branchRepository) {
        super(repository, mapper, branchRepository);
    }
}
