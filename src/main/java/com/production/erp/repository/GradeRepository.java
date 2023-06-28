package com.production.erp.repository;

import com.production.erp.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<GradeEntity, Long> {
    Optional<GradeEntity> findFirstByImeiOrderByIdDesc(Long imei);
}
