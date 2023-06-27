package com.production.erp.converter;

import com.production.erp.entity.ArticleEntity;
import com.production.erp.model.ArticleModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArticleConverter {
    public ArticleModel toModel(ArticleEntity entity) {
        ArticleModel model = new ArticleModel();
        model.setId(entity.getId());
        model.setModel(entity.getModel());
        model.setGb(entity.getGb());
        model.setGrade_sup(entity.getGrade_sup());
        return model;
    }

    public List<ArticleModel> listToModels(List<ArticleEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public ArticleEntity toEntity(ArticleModel model) {
        ArticleEntity entity = new ArticleEntity();
        entity.setId(model.getId());
        entity.setModel(model.getModel());
        entity.setGb(model.getGb());
        entity.setGrade_sup(model.getGrade_sup());
        return entity;
    }

    public List<ArticleEntity> listToEntities(List<ArticleModel> modelList) {
        return modelList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
