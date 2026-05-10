package com.barangay.backend.repository;

import com.barangay.backend.model.Concern;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcernRepository extends JpaRepository<Concern, Long> {
}