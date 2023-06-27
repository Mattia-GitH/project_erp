package com.production.erp.converter;

import com.production.erp.entity.PlanningEntity;
import com.production.erp.model.PlanningModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlanningConverter {
    public PlanningModel toModel(PlanningEntity entity){
        return new PlanningModel(entity.getId(), entity.getDate(), entity.getSku(), entity.getQty(), entity.getStatus(), entity.getOperator());
    }

    public PlanningEntity toEntity(PlanningModel model){
        return new PlanningEntity(model.getId(), model.getDate(), model.getSku(), model.getQty(), model.getStatus(), model.getOperator());
    }

    public List<PlanningModel> listToModels(List<PlanningEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<PlanningEntity> listToEntities(List<PlanningModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
