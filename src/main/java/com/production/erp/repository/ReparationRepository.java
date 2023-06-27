package com.production.erp.repository;

import com.production.erp.entity.ReparationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReparationRepository extends JpaRepository<ReparationEntity, Long> {
    List<ReparationEntity> findByImeiAndDateAfter(Long imei, Date date);
}
