package com.production.erp.repository;

import com.production.erp.entity.BatteryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatteryRepository extends JpaRepository<BatteryEntity, Long> {
    BatteryEntity findFirstByImeiOrderByDateDesc(Long imei);
}
