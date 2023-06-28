package com.production.erp.converter;

import com.production.erp.entity.PolishEntity;
import com.production.erp.model.PolishModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PolishConverter {
    public PolishModel toModel(PolishEntity entity){
        PolishModel model = new PolishModel();
        model.setId(entity.getId());
        model.setImei(entity.getImei());
        model.setDate(entity.getDate());
        model.setOperator(entity.getOperator());
        model.setTime(entity.getTime());
        model.setResult(entity.getResult());

        return model;
    }

    public PolishEntity toEntity(PolishModel model){
        PolishEntity entity = new PolishEntity();
        entity.setId(model.getId());
        entity.setImei(model.getImei());
        entity.setDate(model.getDate());
        entity.setOperator(model.getOperator());
        entity.setTime(model.getTime());
        entity.setResult(model.getResult());

        return entity;
    }

    public List<PolishModel> listToModels(List<PolishEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<PolishEntity> listToEntities(List<PolishModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
