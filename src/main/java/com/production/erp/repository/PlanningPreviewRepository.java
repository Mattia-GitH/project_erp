package com.production.erp.repository;

import com.production.erp.entity.PlanningPreviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanningPreviewRepository extends JpaRepository<PlanningPreviewEntity, Long> {
    @Modifying
    @Query( value = "TRUNCATE planning_preview_tbl", nativeQuery = true)
    void truncate();
}
