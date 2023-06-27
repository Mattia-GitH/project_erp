package com.production.erp.serviceImplement;

import com.production.erp.entity.LastStatusViewEntity;
import com.production.erp.entity.StatusEntity;
import com.production.erp.repository.LastStatusViewRepository;
import com.production.erp.service.LastStatusViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LastStatusViewServiceImp implements LastStatusViewService {

    private final LastStatusViewRepository repository;

    @Autowired
    public LastStatusViewServiceImp(LastStatusViewRepository repository) {
        this.repository = repository;
    }

    @Override
    public LastStatusViewEntity findByImei(Long imei) {
        LastStatusViewEntity statusViewEntity = new LastStatusViewEntity();
        StatusEntity entity = repository.statusView(imei);

        statusViewEntity.setActual_status(entity.getActualStatus());
        statusViewEntity.setImei(entity.getImei());
        statusViewEntity.setDate(entity.getDate());
        statusViewEntity.setOperator(entity.getOperator());
        statusViewEntity.setSend_to(entity.getSend_to());
        return statusViewEntity;
    }

    @Override
    public List<LastStatusViewEntity> findByDateAfter(Date date) {
        return repository.findByDateAfter(date);
    }

    @Override
    public List<LastStatusViewEntity> totalAnalytics() {
        return repository.totalAnalytics();
    }

    @Override
    public List<LastStatusViewEntity> findByNumberOrderBigger() {
        return repository.findByNumberOrderBigger();
    }
}
