package com.production.erp.converter;

import com.production.erp.entity.IssueListEntity;
import com.production.erp.model.IssueListModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IssueListConverter {
    public IssueListModel toModel(IssueListEntity entity){
        return new IssueListModel(entity.getId(), entity.getTl(), entity.getLabel(), entity.getDepartment());
    }

    public IssueListEntity toEntity(IssueListModel model){
        return new IssueListEntity(model.getId(), model.getTl(), model.getLabel(), model.getDepartment());
    }

    public List<IssueListModel> listToModels(List<IssueListEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<IssueListEntity> listToEntities(List<IssueListModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
