package com.mchekhashvili.rental.service.rental;

import com.mchekhashvili.rental.dto.request.rental.ConstructionRentalRequest;
import com.mchekhashvili.rental.dto.response.rental.ConstructionRentalResponse;
import com.mchekhashvili.rental.mapper.rental.ConstructionRentalMapper;
import com.mchekhashvili.rental.model.item.ConstructionEquipmentItem;
import com.mchekhashvili.rental.model.item.RentalItem;
import com.mchekhashvili.rental.model.rental.ConstructionRental;
import com.mchekhashvili.rental.repository.item.RentalItemRepository;
import com.mchekhashvili.rental.repository.rental.ConstructionRentalRepository;
import org.springframework.stereotype.Service;

@Service
public class ConstructionRentalService extends AbstractRentalService<ConstructionRental, ConstructionRentalRequest, ConstructionRentalResponse> {

    public ConstructionRentalService(ConstructionRentalRepository repository, ConstructionRentalMapper mapper, RentalItemRepository<RentalItem> rentalItemRepository) {
        super(repository, mapper, rentalItemRepository);
    }

    @Override
    protected Long getRentalItemId(ConstructionRentalRequest request) {
        return request.getRentalItemId();
    }

    @Override
    protected void validateItemType(RentalItem item) {
        if (!(item instanceof ConstructionEquipmentItem)) {
            throw new IllegalArgumentException("Item is not a construction equipment");
        }
    }
}