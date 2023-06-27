package com.production.erp.service;

import com.production.erp.entity.LastStatusViewEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface LastStatusViewService {
    LastStatusViewEntity findByImei(Long imei);

    List<LastStatusViewEntity> findByDateAfter(Date date);

    List<LastStatusViewEntity> totalAnalytics();

    List<LastStatusViewEntity> findByNumberOrderBigger();
}
