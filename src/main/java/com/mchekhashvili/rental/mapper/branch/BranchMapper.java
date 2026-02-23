package com.mchekhashvili.rental.mapper.branch;

import com.mchekhashvili.rental.dto.request.branch.BranchRequest;
import com.mchekhashvili.rental.dto.response.branch.BranchResponse;
import com.mchekhashvili.rental.model.branch.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BranchMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "rentalItems", ignore = true)
    @Mapping(target = "rentals", ignore = true)
    Branch toEntity(BranchRequest request);

    BranchResponse toResponse(Branch branch);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "rentalItems", ignore = true)
    @Mapping(target = "rentals", ignore = true)
    void updateEntity(BranchRequest request, @MappingTarget Branch branch);
}