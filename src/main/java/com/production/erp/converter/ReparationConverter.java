package com.production.erp.converter;

import com.production.erp.entity.ReparationEntity;
import com.production.erp.entity.StatusEntity;
import com.production.erp.model.ReparationModel;
import com.production.erp.model.StatusModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReparationConverter {
    public ReparationModel toModel(ReparationEntity entity){
        return new ReparationModel(entity.getId(), entity.getImei(), entity.getDate(), entity.getOperator(), entity.getTl(), entity.getComponent());
    }

    public ReparationEntity toEntity(ReparationModel model){
        return new ReparationEntity(model.getId(), model.getImei(), model.getDate(), model.getOperator(), model.getTl(), model.getComponent());
    }

    public List<ReparationModel> listToModels(List<ReparationEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<ReparationEntity> listToEntities(List<ReparationModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
