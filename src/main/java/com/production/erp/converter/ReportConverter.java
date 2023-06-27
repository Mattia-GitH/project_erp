package com.production.erp.converter;

import com.production.erp.entity.ReportEntity;
import com.production.erp.model.ReportModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportConverter {
    public ReportModel toModel(ReportEntity entity){
        return new ReportModel(entity.getId(), entity.getDate(), entity.getReporter(), entity.getIssue(), entity.getOperator(), entity.getImei(), entity.getPhase());
    }

    public ReportEntity toEntity(ReportModel model){
        return new ReportEntity(model.getId(), model.getDate(), model.getReporter(), model.getIssue(), model.getOperator(), model.getImei(), model.getPhase());
    }

    public List<ReportModel> listToModels(List<ReportEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<ReportEntity> listToEntities(List<ReportModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
