package com.production.erp.converter;

import com.production.erp.entity.IssuesEntity;
import com.production.erp.model.IssuesModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IssuesConverter {
    public IssuesModel toModel(IssuesEntity entity){
        IssuesModel model = new IssuesModel();
        model.setId_issue(entity.getId_issue());
        model.setImei(entity.getImei());
        model.setDate(entity.getDate());
        model.setOperator(entity.getOperator());
        return model;
    }

    public IssuesEntity toEntity(IssuesModel model){
        IssuesEntity entity = new IssuesEntity();
        entity.setId_issue(model.getId_issue());
        entity.setImei(model.getImei());
        entity.setDate(model.getDate());
        entity.setOperator(model.getOperator());
        return entity;
    }

    public List<IssuesModel> listToModels(List<IssuesEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<IssuesEntity> listToEntities(List<IssuesModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
