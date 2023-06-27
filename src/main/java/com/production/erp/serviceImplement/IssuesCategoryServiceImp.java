package com.production.erp.serviceImplement;

import com.production.erp.converter.IssuesCategoriesConverter;
import com.production.erp.entity.IssuesCategoriesEntity;
import com.production.erp.exception.IssuesCategoriesException;
import com.production.erp.model.IssuesCategoriesModel;
import com.production.erp.repository.IssuesCategoriesRepository;
import com.production.erp.service.IssuesCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssuesCategoryServiceImp implements IssuesCategoriesService {
    private final IssuesCategoriesRepository repository;
    private final IssuesCategoriesConverter converter;

    @Autowired
    public IssuesCategoryServiceImp(IssuesCategoriesRepository repository, IssuesCategoriesConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public IssuesCategoriesModel createIssuesCategory(IssuesCategoriesModel issuesCategoriesModel) {
        IssuesCategoriesEntity toSave = repository.save(converter.toEntity(issuesCategoriesModel));
        return converter.toModel(toSave);
    }

    @Override
    public List<IssuesCategoriesModel> listIssuesCategories() {
        List<IssuesCategoriesEntity> entityList = repository.findAll();
        return converter.listToModels(entityList);
    }

    @Override
    public IssuesCategoriesModel issuesCategoryById(String id) {
        Optional<IssuesCategoriesEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            return converter.toModel(optional.get());
        } else {
            throw new IssuesCategoriesException("Issues Category not found: " + id);
        }
    }

    @Override
    public IssuesCategoriesModel updateIssuesCategory(IssuesCategoriesModel issuesCategoriesModel, String id) {
        Optional<IssuesCategoriesEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            IssuesCategoriesEntity update = optional.get();
            update.setId(issuesCategoriesModel.getId());
            update.setCode(issuesCategoriesModel.getCode());
            update.setCategory(issuesCategoriesModel.getCategory());
            update.setLabel(issuesCategoriesModel.getLabel());
            repository.save(update);
            return converter.toModel(update);
        } else {
            throw new IssuesCategoriesException("Issues Category not found: " + id);
        }
    }

    @Override
    public String delete(String id) {
        Optional<IssuesCategoriesEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return "Issues Category deleted: " + optional.get();
        } else {
            throw new IssuesCategoriesException("Issues Category not found: " + id);
        }
    }
}
