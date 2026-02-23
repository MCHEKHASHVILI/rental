package com.mchekhashvili.rental.repository.item;

import com.mchekhashvili.rental.model.item.VehicleItem;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleItemRepository extends RentalItemRepository<VehicleItem> {
}