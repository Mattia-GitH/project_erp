package com.production.erp.converter;

import com.production.erp.entity.PlanningPreviewEntity;
import com.production.erp.model.PlanningPreviewModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlanningPreviewConverter {
    public PlanningPreviewModel toModel(PlanningPreviewEntity entity){
        return new PlanningPreviewModel(entity.getId(), entity.getDate(), entity.getSku(), entity.getQty(), entity.getStatus(), entity.getOperator());
    }

    public PlanningPreviewEntity toEntity(PlanningPreviewModel model){
        return new PlanningPreviewEntity(model.getId(), model.getDate(), model.getSku(), model.getQty(), model.getStatus(), model.getOperator());
    }

    public List<PlanningPreviewModel> listToModels(List<PlanningPreviewEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<PlanningPreviewEntity> listToEntities(List<PlanningPreviewModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
