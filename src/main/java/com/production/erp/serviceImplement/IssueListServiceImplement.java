package com.production.erp.serviceImplement;

import com.production.erp.converter.IssueListConverter;
import com.production.erp.entity.IssueListEntity;
import com.production.erp.exception.IssueListNotFoundException;
import com.production.erp.model.IssueListModel;
import com.production.erp.repository.IssueListRepository;
import com.production.erp.service.IssueListService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueListServiceImplement implements IssueListService {
    private final IssueListRepository repository;
    private final IssueListConverter converter;

    public IssueListServiceImplement(IssueListRepository repository, IssueListConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public IssueListModel createIssue(IssueListModel issuesModel) {
        return converter.toModel(repository.save(converter.toEntity(issuesModel)));
    }

    @Override
    public List<IssueListModel> listIssues() {
        return converter.listToModels(repository.findAll());
    }

    @Override
    public IssueListModel issuesById(Long id) {
        return converter.toModel(repository.findById(id).map(IssueListEntity::new).orElseThrow(() -> new IssueListNotFoundException("Issue not found: " + id)));
    }

    @Override
    public IssueListModel updateIssues(IssueListModel issuesModel, Long id) {
        return converter.toModel(repository.findById(id).map(repository::save).orElseThrow(() -> new IssueListNotFoundException("Issue not found: " + id)));
    }

    @Override
    public String delete(Long id) {
        Optional<IssueListEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return "Deleted: " + id;
        } else {
            throw new IssueListNotFoundException("Issue not found: " + id);
        }
    }

    @Override
    public boolean findByTl(String tl) {
        if (tl == null){
            return false;
        } else {
            Optional<IssueListEntity> optional = repository.findByTl(tl);
            return optional.isPresent();
        }
    }
}
