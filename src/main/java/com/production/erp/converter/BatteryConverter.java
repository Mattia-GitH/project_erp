package com.production.erp.converter;

import com.production.erp.entity.BatteryEntity;
import com.production.erp.model.BatteryModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BatteryConverter {

    public BatteryModel toModel(BatteryEntity entity){
        BatteryModel model = new BatteryModel();
        model.setId(entity.getId());
        model.setImei(entity.getImei());
        model.setSoh(entity.getSoh());
        model.setCycles(entity.getCycles());
        model.setReplace(entity.isReplace());
        model.setDate(entity.getDate());
        return model;
    }

    public BatteryEntity toEntity(BatteryModel model){
        BatteryEntity entity = new BatteryEntity();
        entity.setId(model.getId());
        entity.setImei(model.getImei());
        entity.setSoh(model.getSoh());
        entity.setCycles(model.getCycles());
        entity.setReplace(model.isReplace());
        entity.setDate(model.getDate());
        return entity;
    }

    public List<BatteryModel> listToModels(List<BatteryEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<BatteryEntity> listToEntities(List<BatteryModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
