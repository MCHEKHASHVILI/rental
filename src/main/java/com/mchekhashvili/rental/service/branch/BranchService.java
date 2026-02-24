package com.mchekhashvili.rental.service.branch;

import com.mchekhashvili.rental.dto.request.branch.BranchRequest;
import com.mchekhashvili.rental.dto.response.branch.BranchResponse;

import java.util.List;

public interface BranchService {
    List<BranchResponse> findAll();
    List<BranchResponse> findAllInactive();
    BranchResponse findById(Long id);
    BranchResponse save(BranchRequest request);
    BranchResponse update(Long id, BranchRequest request);
    void delete(Long id);
    BranchResponse restore(Long id);
}
