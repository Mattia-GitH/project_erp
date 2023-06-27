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
        model.setImei(entity.getImei());
        model.setGrade_sup(entity.getGrade_sup());
        model.setGrade_check(entity.getGrade_check());
        return model;
    }

    public GradeEntity toEntity(GradeModel model) {
        GradeEntity entity = new GradeEntity();
        entity.setImei(model.getImei());
        entity.setGrade_sup(model.getGrade_sup());
        entity.setGrade_check(model.getGrade_check());
        return entity;
    }

    public List<GradeModel> listToModels(List<GradeEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<GradeEntity> listToEntities(List<GradeModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
