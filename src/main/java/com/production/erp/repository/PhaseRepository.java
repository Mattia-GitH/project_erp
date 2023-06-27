package com.production.erp.repository;

import com.production.erp.entity.PhasesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhaseRepository extends JpaRepository<PhasesEntity, String> {
}
