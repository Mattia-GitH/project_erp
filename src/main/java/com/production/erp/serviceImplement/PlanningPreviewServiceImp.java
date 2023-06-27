package com.production.erp.serviceImplement;

import com.production.erp.converter.PlanningPreviewConverter;
import com.production.erp.entity.PlanningPreviewEntity;
import com.production.erp.exception.PlanningPreviewNotFound;
import com.production.erp.model.PlanningPreviewModel;
import com.production.erp.repository.PlanningPreviewRepository;
import com.production.erp.service.PlanningPreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlanningPreviewServiceImp implements PlanningPreviewService {
    private final PlanningPreviewRepository repository;
    private final PlanningPreviewConverter converter;

    @Autowired
    public PlanningPreviewServiceImp(PlanningPreviewRepository repository, PlanningPreviewConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }


    @Override
    public PlanningPreviewModel createPlan(PlanningPreviewModel planningPreviewModel) {
        return converter.toModel(repository.save(converter.toEntity(planningPreviewModel)));
    }

    @Override
    public List<PlanningPreviewModel> planList() {
        return converter.listToModels(repository.findAll());
    }

    @Override
    public PlanningPreviewModel planById(Long id) {
        return converter.toModel(repository.findById(id).map(PlanningPreviewEntity::new).orElseThrow(() -> new PlanningPreviewNotFound("plan not found " + id)));
    }

    @Override
    public PlanningPreviewModel updatePlan(PlanningPreviewModel planningPreviewModel, Long id) {
        return converter.toModel(repository.findById(id).map(repository::save).orElseThrow(() -> new PlanningPreviewNotFound("plan not found " + id)));
    }

    @Override
    public String delete(Long id) {
        Optional<PlanningPreviewEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return "Deleted " + optional.get();
        } else {
            throw new PlanningPreviewNotFound("plan not found " + id);
        }
    }

    @Transactional
    @Override
    public String truncate() {
        repository.truncate();
        return "truncated";
    }
}
