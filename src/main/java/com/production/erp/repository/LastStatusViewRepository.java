package com.production.erp.repository;

import com.production.erp.entity.LastStatusViewEntity;
import com.production.erp.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LastStatusViewRepository extends JpaRepository<LastStatusViewEntity, Long> {

    @Query("SELECT s FROM StatusEntity AS s WHERE s.date in (select max(s2.date) from StatusEntity s2 where :imei = s2.imei) AND s.imei = :imei GROUP BY s.imei ORDER BY s.date ASC")
    StatusEntity statusView(@Param("imei")Long imei);

    @Query("select s from LastStatusViewEntity s where s.date > :date")
    List<LastStatusViewEntity> findByDateAfter(@Param("date") Date date);

    @Query("SELECT s FROM LastStatusViewEntity AS s")
    List<LastStatusViewEntity> totalAnalytics();

    @Query("SELECT s FROM LastStatusViewEntity AS s INNER JOIN PhoneEntity AS p ON p.imei = s.imei WHERE s.send_to IS NOT NULL AND p.order_number > 38")
    List<LastStatusViewEntity> findByNumberOrderBigger();
}
