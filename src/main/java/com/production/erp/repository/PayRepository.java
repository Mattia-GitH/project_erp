package com.production.erp.repository;

import com.production.erp.entity.PayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRepository extends JpaRepository<PayEntity, Long> {
    @Query("select new com.production.erp.entity.PayEntity(p.number_order, p.paid, p.payment_options) from PayEntity p where p.number_order = :order_number")
    PayEntity findByNumber_order(@Param("order_number") Long order_number);
}
