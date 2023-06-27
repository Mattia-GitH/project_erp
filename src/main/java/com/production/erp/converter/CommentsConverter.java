package com.production.erp.converter;

import com.production.erp.entity.CommentsEntity;
import com.production.erp.model.CommentsModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentsConverter {

    public CommentsModel toModel(CommentsEntity entity) {
        CommentsModel model = new CommentsModel();
        model.setId(entity.getId());
        model.setImei(entity.getImei());
        model.setDate(entity.getDate());
        model.setId_issue(entity.getId_issue());
        model.setStatus(entity.getStatus());
        model.setComment(entity.getComment());
        model.setOperator(entity.getOperator());
        return model;
    }

    public CommentsEntity toEntity(CommentsModel model) {
        CommentsEntity entity = new CommentsEntity();
        entity.setId(model.getId());
        entity.setImei(model.getImei());
        entity.setDate(model.getDate());
        entity.setId_issue(model.getId_issue());
        entity.setStatus(model.getStatus());
        entity.setComment(model.getComment());
        entity.setOperator(model.getOperator());
        return entity;
    }


    public List<CommentsModel> listToModels(List<CommentsEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<CommentsEntity> listToEntities(List<CommentsModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
