package com.production.erp.repository;

import com.production.erp.entity.PolishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PolishRepository extends JpaRepository<PolishEntity, Long> {

    Optional<PolishEntity> findFirstByImeiOrderByIdDesc(Long imei);

    List<PolishEntity> findByImei(Long imei);
}
