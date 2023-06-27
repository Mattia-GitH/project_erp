package com.production.erp.repository;

import com.production.erp.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
    @Query(value = "SELECT * FROM REPORT_TBL WHERE ISSUE = :issue AND OPERATOR = :operator AND REPORTER = :reporter AND imei = :imei AND date BETWEEN NOW() - 10000 AND NOW();", nativeQuery = true)
    ReportEntity alreadyReported(@Param("issue")String issue, @Param("operator")String operator, @Param("reporter")String reporter, @Param("imei")Long imei);

    @Query("SELECT r FROM ReportEntity AS r WHERE r.date > :smallDate AND r.date < :bigDate AND r.imei = :imei")
    List<ReportEntity> loadReports(@Param("bigDate")Date bigDate, @Param("smallDate")Date smallDate, @Param("imei")Long imei);
}
