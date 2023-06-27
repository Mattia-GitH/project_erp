package com.production.erp.service;

import com.production.erp.model.StatusModel;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface StatusService {
    StatusModel createStatus(StatusModel statusModel);

    List<StatusModel> listStatus();

    StatusModel statusByImei(Long imei);

    StatusModel updateStatus(StatusModel statusModel, Long id);

    String delete(Long imei);

    boolean isPresent(Long imei);

    StatusModel findStatusToUpdate(Long imei, String actual_status, String operator);

    StatusModel lastStatus(Long imei);

    String deleteById(Long id);

    StatusModel findByImeiOrderByDateDesc(Long imei);

    List<StatusModel> findTop2ByImeiOrderByDateDesc(Long imei);

    List<Date> findDatesForReport();

    StatusModel findFirstByDateBetweenAndImei(Date firstDate, Date secondDate, Long imei);

    List<StatusModel> findByOperatorAndDateBetween(String operator, Date firstDate, Date secondDate);

    StatusModel findAvgTimeOperator(java.sql.Date date, String operator);

    List<StatusModel> findByDateGroupByImei(Date date, Date date2);

    List<StatusModel> findFirstAndLastTimeOperator(Date date, String operator, Date date2);

    List<StatusModel> findAllItcToExport(Date date, Date date2);
}
