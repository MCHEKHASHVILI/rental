package com.mchekhashvili.rental.repository.item;

import com.mchekhashvili.rental.enums.ItemStatus;
import com.mchekhashvili.rental.model.item.RentalItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseRentalItemRepository extends JpaRepository<RentalItem, Long> {
    List<RentalItem> findAllByStatus(ItemStatus status);
}
