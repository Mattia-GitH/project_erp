package com.production.erp.repository;

import com.production.erp.entity.ShippingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingEntity, Long> {
    Optional<List<ShippingEntity>> findByImei(Long imei);

    ShippingEntity findFirstByImeiOrderByDateDesc(Long imei);
}
