package com.mchekhashvili.rental.repository.branch;

import com.mchekhashvili.rental.model.branch.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    List<Branch> findAllByActiveTrue();
    List<Branch> findAllByActiveFalse();
    Optional<Branch> findByIdAndActiveTrue(Long id);
    Optional<Branch> findByIdAndActiveFalse(Long id);
}
