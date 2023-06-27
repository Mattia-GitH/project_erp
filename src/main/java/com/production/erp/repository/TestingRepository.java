package com.production.erp.repository;

import com.production.erp.entity.TestingEntity;
import com.production.erp.service.TestingService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TestingRepository extends JpaRepository<TestingEntity, Long> {

    Optional<TestingEntity> findByImei(Long imei);

    Optional<TestingEntity> findByImeiAndDate(Long imei, Date date);

    String deleteByImeiAndDate(Long imei, Date date);

    @Query("SELECT t FROM TestingEntity AS t WHERE t.imei = :imei ORDER BY t.date DESC ")
    List<TestingEntity> lastTest(@Param("imei")Long imei);

    TestingEntity findFirstByImeiOrderByDateDesc(@Param("imei")Long imei);

    Optional<TestingEntity> findFirstByImeiAndDateBetweenOrderByDateDesc(@Param("imei")Long imei, @Param("date")Date date, @Param("date2")Date date2);

    @Modifying
    @Query(value = "SELECT * FROM iOS_TBL", nativeQuery = true)
    List<BigDecimal> iOS();
}
