package com.production.erp.converter;

import com.production.erp.entity.StatusEntity;
import com.production.erp.model.StatusModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatusConverter {
    public StatusModel toModel(StatusEntity entity){
        StatusModel model = new StatusModel();
        model.setId(entity.getId());
        model.setImei(entity.getImei());
        model.setDate(entity.getDate());
        model.setActual_status(entity.getActualStatus());
        model.setSend_to(entity.getSend_to());
        model.setTimer(entity.getTimer());
        model.setOperator(entity.getOperator());
        return model;
    }

    public StatusEntity toEntity(StatusModel model){
        StatusEntity entity = new StatusEntity();
        entity.setId(model.getId());
        entity.setImei(model.getImei());
        entity.setDate(model.getDate());
        entity.setActualStatus(model.getActual_status());
        entity.setSend_to(model.getSend_to());
        entity.setTimer(model.getTimer());
        entity.setOperator(model.getOperator());
        return entity;
    }

    public List<StatusModel> listToModels(List<StatusEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<StatusEntity> listToEntities(List<StatusModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
