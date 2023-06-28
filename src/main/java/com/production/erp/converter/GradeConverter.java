package com.production.erp.converter;

import com.production.erp.entity.GradeEntity;
import com.production.erp.model.GradeModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GradeConverter {
    public GradeModel toModel(GradeEntity entity) {
        GradeModel model = new GradeModel();
        model.setId(entity.getId());
        model.setImei(entity.getImei());
        model.setGrade_sup(entity.getGrade_sup());
        model.setGrade_check(entity.getGrade_check());
        model.setOperator(entity.getOperator());
        model.setPhase(entity.getPhase());
        return model;
    }

    public GradeEntity toEntity(GradeModel model) {
        GradeEntity entity = new GradeEntity();
        entity.setId(model.getId());
        entity.setImei(model.getImei());
        entity.setGrade_sup(model.getGrade_sup());
        entity.setGrade_check(model.getGrade_check());
        entity.setOperator(model.getOperator());
        entity.setPhase(model.getPhase());
        return entity;
    }

    public List<GradeModel> listToModels(List<GradeEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<GradeEntity> listToEntities(List<GradeModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
