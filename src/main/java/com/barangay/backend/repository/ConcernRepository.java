package com.barangay.backend.repository;

import com.barangay.backend.model.Concern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConcernRepository extends JpaRepository<Concern, Long> {
    List<Concern> findByUserId(Long userId);
}