package com.mchekhashvili.rental.service.branch;

import com.mchekhashvili.rental.dto.request.branch.BranchRequest;
import com.mchekhashvili.rental.dto.response.branch.BranchResponse;
import com.mchekhashvili.rental.mapper.branch.BranchMapper;
import com.mchekhashvili.rental.model.branch.Branch;
import com.mchekhashvili.rental.repository.branch.BranchRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository repository;
    private final BranchMapper mapper;

    @Override
    @Cacheable(value = "branches")
    public List<BranchResponse> findAll() {
        return repository.findAllByActiveTrue()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Cacheable(value = "branch", key = "#id")
    public BranchResponse findById(Long id) {
        return mapper.toResponse(findEntityById(id));
    }

    @Override
    @CacheEvict(value = "branches", allEntries = true)
    public BranchResponse save(BranchRequest request) {
        Branch branch = mapper.toEntity(request);
        return mapper.toResponse(repository.save(branch));
    }

    @Override
    @Caching(evict = @CacheEvict(value = "branches", allEntries = true),
             put = @CachePut(value = "branch", key = "#id"))
    public BranchResponse update(Long id, BranchRequest request) {
        Branch existing = findEntityById(id);
        mapper.updateEntity(request, existing);
        return mapper.toResponse(repository.save(existing));
    }

    @Override
    @Caching(evict = {
            @CacheEvict(value = "branches", allEntries = true),
            @CacheEvict(value = "branch", key = "#id")
    })
    public void delete(Long id) {
        Branch existing = findEntityById(id);
        existing.setActive(false);
        repository.save(existing);
    }

    private Branch findEntityById(Long id) {
        return repository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new EntityNotFoundException("Branch not found with id: " + id));
    }
}
