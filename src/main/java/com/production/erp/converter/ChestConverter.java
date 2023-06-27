package com.production.erp.converter;

import com.production.erp.entity.ChestEntity;
import com.production.erp.model.ChestModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChestConverter {
    public ChestModel toModel(ChestEntity entity){
        ChestModel model = new ChestModel();
        model.setId(entity.getId());
        model.setNumber(entity.getNumber());
        model.setImei(entity.getImei());
        model.setPhase(entity.getPhase());

        return model;
    }

    public ChestEntity toEntity(ChestModel model){
        ChestEntity entity = new ChestEntity();
        entity.setId(model.getId());
        entity.setNumber(model.getNumber());
        entity.setImei(model.getImei());
        entity.setPhase(model.getPhase());

        return entity;
    }

    public List<ChestModel> listToModels(List<ChestEntity> componentEntities) {
        return componentEntities.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<ChestEntity> listToEntities(List<ChestModel> componentModels) {
        return componentModels.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
