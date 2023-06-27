package com.production.erp.converter;

import com.production.erp.entity.IssuesCategoriesEntity;
import com.production.erp.model.IssuesCategoriesModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IssuesCategoriesConverter {
    public IssuesCategoriesModel toModel(IssuesCategoriesEntity entity) {
        IssuesCategoriesModel model = new IssuesCategoriesModel();
        model.setId(entity.getId());
        model.setCode(entity.getCode());
        model.setCategory(entity.getCategory());
        model.setLabel(entity.getLabel());
        return model;
    }

    public IssuesCategoriesEntity toEntity(IssuesCategoriesModel model) {
        IssuesCategoriesEntity entity = new IssuesCategoriesEntity();
        entity.setId(model.getId());
        entity.setCode(model.getCode());
        entity.setCategory(model.getCategory());
        entity.setLabel(model.getLabel());
        return entity;
    }

    public List<IssuesCategoriesModel> listToModels(List<IssuesCategoriesEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<IssuesCategoriesEntity> listToEntities(List<IssuesCategoriesModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
