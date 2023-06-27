package com.production.erp.repository;

import com.production.erp.entity.PlanningEntity;
import com.production.erp.view.PlanProgress;
import com.production.erp.view.PlanningView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlanningRepository extends JpaRepository<PlanningEntity, Long> {
    @Query("SELECT new com.production.erp.view.PlanningView(COUNT(p.sku) ,s.send_to, p.sku, p.model, p.gb, p.color, g.grade_check) FROM PhoneEntity AS p LEFT JOIN GradeEntity AS g ON p.imei = g.imei LEFT JOIN LastStatusViewEntity AS s ON p.imei = s.imei WHERE (:status IS NULL OR s.send_to = :status) AND p.sku LIKE :filter GROUP BY p.sku, s.send_to")
    List<PlanningView> planningView(@Param("status")String status, @Param("filter")String filter);

    @Query("SELECT new com.production.erp.view.PlanningView(COUNT(p.sku) ,s.send_to, p.sku, p.model, p.gb, p.color, g.grade_check) FROM PhoneEntity AS p LEFT JOIN GradeEntity AS g ON p.imei = g.imei LEFT JOIN LastStatusViewEntity AS s ON p.imei = s.imei WHERE s.send_to IS NULL AND p.sku LIKE :filter GROUP BY p.sku, s.send_to")
    List<PlanningView> planningViewITC(@Param("filter")String filter);

    @Query("SELECT new com.production.erp.entity.PlanningEntity(p.id, p.date, p.sku, SUM(p.qty), p.status) FROM PlanningEntity AS p WHERE (:date IS NULL OR p.date = :date) AND (:status IS NULL OR p.status = :status) AND (:sku IS NULL OR p.sku = :sku) GROUP BY p.sku, p.status, p.date ORDER BY p.date DESC")
    List<PlanningEntity> planned(@Param("date")Date date, @Param("status")String status, @Param("sku")String sku);

    @Query("SELECT p FROM PlanningEntity AS p WHERE p.date = :date AND p.status = :status AND p.sku = :sku ORDER BY p.date DESC")
    List<PlanningEntity> plannedDetail(@Param("date")Date date, @Param("status")String status, @Param("sku")String sku);

    @Query("SELECT new com.production.erp.view.PlanProgress(s.date, p.sku, COUNT(s.id), s.actualStatus, s.operator) FROM StatusEntity AS s INNER JOIN PhoneEntity AS p ON s.imei = p.imei WHERE s.date BETWEEN :startDate AND :finishDate GROUP BY s.operator, s.actualStatus, p.sku ORDER BY s.date DESC")
    List<PlanProgress> planProgress(@Param("startDate")Date startDate, @Param("finishDate")Date finishDate);

    @Query("SELECT p FROM PlanningEntity AS p WHERE p.date = :date AND p.sku = :sku AND p.status = :status")
    Optional<PlanningEntity> isAlreadyPlanned(@Param("date")Date date, @Param("sku")String sku, @Param("status")String status);

    @Modifying
    @Query("DELETE FROM PlanningEntity WHERE date = :date AND status = :status AND sku = :sku")
    void deletePlan(@Param("date")Date date, @Param("status")String status, @Param("sku")String sku);

    PlanningEntity findByDateAndStatusAndSkuAndOperator(Date date, String status, String sku, String operator);
}
