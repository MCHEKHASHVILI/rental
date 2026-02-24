package com.mchekhashvili.rental.service.item;

import com.mchekhashvili.rental.dto.request.item.ConstructionEquipmentItemRequest;
import com.mchekhashvili.rental.dto.response.item.ConstructionEquipmentItemResponse;
import com.mchekhashvili.rental.mapper.item.ConstructionEquipmentItemMapper;
import com.mchekhashvili.rental.model.item.ConstructionEquipmentItem;
import com.mchekhashvili.rental.repository.branch.BranchRepository;
import com.mchekhashvili.rental.repository.item.ConstructionEquipmentItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ConstructionEquipmentItemService extends AbstractRentalItemService<ConstructionEquipmentItem, ConstructionEquipmentItemRequest, ConstructionEquipmentItemResponse> {

    public ConstructionEquipmentItemService(ConstructionEquipmentItemRepository repository, ConstructionEquipmentItemMapper mapper, BranchRepository branchRepository) {
        super(repository, mapper, branchRepository);
    }
}
