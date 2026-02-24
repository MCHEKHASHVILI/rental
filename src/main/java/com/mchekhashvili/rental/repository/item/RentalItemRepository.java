package com.mchekhashvili.rental.repository.item;

import com.mchekhashvili.rental.model.item.RentalItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalItemRepository<T extends RentalItem> extends JpaRepository<T, Long> {
}