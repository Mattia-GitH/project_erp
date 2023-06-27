package com.production.erp.repository;

import com.production.erp.analytic.StatusAnalytics;
import com.production.erp.entity.StatusEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long> {

    StatusEntity findFirstByImeiAndActualStatusAndOperatorOrderByDateDesc(@Param("imei")Long imei, @Param("actual_status")String actual_status, @Param("operator")String operator);

    @Query("SELECT s FROM StatusEntity AS s WHERE s.imei = :imei ORDER BY s.date DESC")
    List<StatusEntity> lastStatus(@Param("imei")Long imei);

    void deleteById(Long id);

    Optional<StatusEntity> findFirstByImeiOrderByDateDesc(Long imei);

    List<StatusEntity> findAllByImeiOrderByDateDesc(Long imei);

    List<StatusEntity> findTop2ByImeiOrderByDateDesc(Long imei);

    List<StatusEntity> findAllByOrderByDateDesc();

    List<StatusEntity> findTop2ByOrderByDateDesc();

    Optional<StatusEntity> findFirstByDateBetweenAndImeiAndActualStatus(@Param("firstDate") Date firstDate, @Param("secondDate")Date secondDate, @Param("imei")Long imei, @Param("status")String status);

    @Query("select s from StatusEntity s " +
            "where s.operator = :operator and s.date between :firstDate and :secondDate " +
            "group by s.imei" +
            " order by s.date DESC")
    List<StatusEntity> findByOperatorAndDateBetweenOrderByDateDesc(@Param("operator") String operator, @Param("firstDate") Date firstDate,@Param("secondDate") Date secondDate);

    @Query(value = "SELECT new com.production.erp.analytic.StatusAnalytics(s.id, s.imei, s.date, s.actualStatus, s.send_to, s.operator, FUNCTION('SEC_TO_TIME', AVG(FUNCTION('TIME_TO_SEC', s.timer)))) FROM StatusEntity AS s WHERE s.date > :date AND s.operator = :operator ORDER BY s.date DESC")
    StatusAnalytics findAvgTimeOperator(@Param("date") java.sql.Date date, @Param("operator") String operator);

    @Query("SELECT s FROM StatusEntity AS s WHERE s.date > :date AND s.date < :date2 AND s.send_to IS NOT NULL GROUP BY s.imei, s.actualStatus, s.operator")
    List<StatusEntity> findByDateGroupByImei(@Param("date") Date date, @Param("date2") Date date2);

    @Query(value = "SELECT * FROM STATUS_TBL AS s WHERE s.date > :date AND s.date < :date2 AND s.operator = :operator ORDER BY s.date DESC LIMIT 1", nativeQuery = true)
    StatusEntity findLastTimeOperator(@Param("date")Date date, @Param("operator") String operator, @Param("date2") Date date2);

    @Query(value = "SELECT * FROM STATUS_TBL AS s WHERE s.date > :date AND s.date < :date2 AND s.operator = :operator ORDER BY s.date ASC LIMIT 1", nativeQuery = true)
    StatusEntity findFirstTimeOperator(@Param("date")Date date, @Param("operator") String operator, @Param("date2") Date date2);

    @Query("SELECT s FROM StatusEntity AS s WHERE s.actualStatus = 'ITC' AND s.date BETWEEN :date AND :date2 GROUP BY s.imei ORDER BY s.date ASC")
    List<StatusEntity> findAllItcToExport(@Param("date") Date date, @Param("date2") Date date2);
}
