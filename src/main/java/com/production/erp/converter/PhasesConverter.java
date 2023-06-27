package com.production.erp.converter;

import com.production.erp.entity.PhasesEntity;
import com.production.erp.entity.PhoneEntity;
import com.production.erp.model.PhasesModel;
import com.production.erp.model.PhoneModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhasesConverter {
    public PhasesModel toModel(PhasesEntity entity){
        return new PhasesModel(entity.getPhase());
    }

    public PhasesEntity toEntity(PhasesModel model){
        return new PhasesEntity(model.getPhase());
    }

    public List<PhasesModel> listToModels(List<PhasesEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<PhasesEntity> listToEntities(List<PhasesModel> modelList) {
        return modelList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
