package com.production.erp.serviceImplement;

import com.production.erp.analytic.StatusAnalytics;
import com.production.erp.converter.StatusConverter;
import com.production.erp.entity.StatusEntity;
import com.production.erp.exception.StatusNotFoundException;
import com.production.erp.model.StatusModel;
import com.production.erp.repository.StatusRepository;
import com.production.erp.service.StatusService;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImp implements StatusService {
    private final StatusRepository repository;
    private final StatusConverter converter;

    @Autowired
    public StatusServiceImp(StatusRepository repository, StatusConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public StatusModel createStatus(StatusModel statusModel) {
        StatusEntity toSave = repository.save(converter.toEntity(statusModel));
        return converter.toModel(toSave);
    }

    @Override
    public List<StatusModel> listStatus() {
        List<StatusEntity> entityList = repository.findAll();
        return converter.listToModels(entityList);
    }

    @Override
    public StatusModel statusByImei(Long imei) {
        Optional<StatusEntity> optional = repository.findById(imei);
        if (optional.isPresent()) {
            return converter.toModel(optional.get());
        } else {
            throw new StatusNotFoundException("Status not found: " + imei);
        }
    }

    @Override
    public StatusModel updateStatus(StatusModel statusModel, Long id) {
        Optional<StatusEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            StatusEntity update = optional.get();
            update.setSend_to(statusModel.getSend_to());
            update.setTimer(statusModel.getTimer());
            repository.save(update);
            return converter.toModel(optional.get());
        } else {
            throw new StatusNotFoundException("Status not found: " + id);
        }
    }

    @Override
    public String delete(Long imei) {
        Optional<StatusEntity> optional = repository.findById(imei);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return "Status deleted: " + optional.get();
        } else {
            throw new StatusNotFoundException("Status not found: " + imei);
        }
    }

    public boolean isPresent(Long imei) {
        Optional<StatusEntity> optional = repository.findById(imei);
        return optional.isPresent();
    }

    @Override
    public StatusModel findStatusToUpdate(Long imei, String actual_status, String operator) {
        return converter.toModel(repository.findFirstByImeiAndActualStatusAndOperatorOrderByDateDesc(imei, actual_status, operator));
    }

    @Override
    public StatusModel lastStatus(Long imei) {
        return converter.toModel(repository.lastStatus(imei).get(0));
    }

    @Override
    public String deleteById(Long id) {
        Optional<StatusEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.deleteById(optional.get().getId());
            return "Status deleted: " + optional.get();
        } else {
            throw new StatusNotFoundException("Status not found: " + id);
        }
    }

    @Override
    public StatusModel findByImeiOrderByDateDesc(Long imei) {
        Optional<StatusEntity> optional = repository.findFirstByImeiOrderByDateDesc(imei);
        if (optional.isPresent()) {
            return converter.toModel(optional.get());
        } else {
            return new StatusModel();
        }
    }

    @Override
    public List<StatusModel> findTop2ByImeiOrderByDateDesc(Long imei) {
        return converter.listToModels(repository.findTop2ByImeiOrderByDateDesc(imei));
    }


    @Override
    public List<Date> findDatesForReport() {
        List<StatusModel> statusModels = converter.listToModels(repository.findTop2ByOrderByDateDesc());
        List<Date> dates = new ArrayList<>();
        statusModels.forEach(s -> dates.add(s.getDate()));
        return dates;
    }

    @Override
    public StatusModel findFirstByDateBetweenAndImei(Date firstDate, Date secondDate, Long imei) {
        Optional<StatusEntity> optional = repository.findFirstByDateBetweenAndImeiAndActualStatus(firstDate, secondDate, imei, "ITC");
        if (optional.isPresent()) {
            return converter.toModel(optional.get());
        } else {
            StatusModel statusModel = new StatusModel();
            LocalTime time = LocalTime.now();
            statusModel.setTimer(time);
            return statusModel;
        }
    }

    @Override
    public List<StatusModel> findByOperatorAndDateBetween(String operator, Date firstDate, Date secondDate) {
        return converter.listToModels(repository.findByOperatorAndDateBetweenOrderByDateDesc(operator, firstDate, secondDate));
    }

    @Override
    public StatusModel findAvgTimeOperator(java.sql.Date date, String operator) {
        StatusAnalytics statusAnalytics = repository.findAvgTimeOperator(date, operator);
        StatusModel model = new StatusModel();
        model.setId(statusAnalytics.getId());
        model.setDate(statusAnalytics.getDate());
        model.setOperator(statusAnalytics.getOperator());
        model.setActual_status(statusAnalytics.getActualStatus());
        model.setSend_to(statusAnalytics.getSend_to());
        model.setTimer(LocalTime.parse(statusAnalytics.getTimer().toString()));
        return model;
    }

    @Override
    public List<StatusModel> findByDateGroupByImei(Date date, Date date2) {
        return converter.listToModels(repository.findByDateGroupByImei(date, date2));
    }

    @Override
    public List<StatusModel> findFirstAndLastTimeOperator(Date date, String operator, Date date2) {
        StatusModel first = converter.toModel(repository.findFirstTimeOperator(date, operator, date2));
        StatusModel last = converter.toModel(repository.findLastTimeOperator(date, operator, date2));

        List<StatusModel> firstAndLast = new ArrayList<>();
        firstAndLast.add(first);
        firstAndLast.add(last);

        return firstAndLast;
    }

    @Override
    public List<StatusModel> findAllItcToExport(Date date, Date date2) {
        return converter.listToModels(repository.findAllItcToExport(date, date2));
    }
}
