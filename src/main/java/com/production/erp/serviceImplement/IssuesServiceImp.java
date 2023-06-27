package com.production.erp.serviceImplement;

import com.production.erp.converter.IssuesConverter;
import com.production.erp.entity.IssuesEntity;
import com.production.erp.exception.IssuesNotFoundException;
import com.production.erp.model.IssuesModel;
import com.production.erp.repository.IssuesRepository;
import com.production.erp.service.IssuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssuesServiceImp implements IssuesService {
    private final IssuesRepository repository;
    private final IssuesConverter converter;

    @Autowired
    public IssuesServiceImp(IssuesRepository repository, IssuesConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public IssuesModel createIssue(IssuesModel issuesModel) {
        IssuesEntity toSave = repository.save(converter.toEntity(issuesModel));
        return converter.toModel(toSave);
    }

    @Override
    public List<IssuesModel> listIssues() {
        List<IssuesEntity> entityList = repository.findAll();
        return converter.listToModels(entityList);
    }

    @Override
    public IssuesModel issuesByImei(Long imei) {
        Optional<IssuesEntity> optional = repository.findById(imei);
        if (optional.isPresent()){
            return converter.toModel(optional.get());
        } else {
            throw new IssuesNotFoundException("Issues not found: " + imei);
        }
    }

    @Override
    public IssuesModel updateIssues(IssuesModel issuesModel, Long imei) {
        Optional<IssuesEntity> optional = repository.findById(imei);
        if (optional.isPresent()){
            IssuesEntity update = optional.get();
            update.setId_issue(issuesModel.getId_issue());
            update.setImei(issuesModel.getImei());
            update.setDate(issuesModel.getDate());
            update.setOperator(issuesModel.getOperator());
            repository.save(update);
            return converter.toModel(update);
        } else {
            throw new IssuesNotFoundException("Issues not found: " + imei);
        }
    }

    @Override
    public String delete(Long imei) {
        Optional<IssuesEntity> optional = repository.findById(imei);
        if (optional.isPresent()){
            repository.delete(optional.get());
            return "Issue deleted: " + optional.get();
        } else {
            throw new IssuesNotFoundException("Issues not found: " + imei);
        }
    }
}
