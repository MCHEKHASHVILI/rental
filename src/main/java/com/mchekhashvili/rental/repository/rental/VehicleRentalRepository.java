package com.mchekhashvili.rental.repository.rental;

import com.mchekhashvili.rental.model.rental.VehicleRental;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRentalRepository extends RentalRepository<VehicleRental> {
}