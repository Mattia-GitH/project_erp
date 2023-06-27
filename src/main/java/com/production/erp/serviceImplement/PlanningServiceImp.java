package com.production.erp.serviceImplement;

import com.production.erp.converter.PlanningConverter;
import com.production.erp.entity.PlanningEntity;
import com.production.erp.exception.PlanningNotFoundException;
import com.production.erp.model.PlanningModel;
import com.production.erp.repository.PlanningRepository;
import com.production.erp.service.PlanningService;
import com.production.erp.view.PlanProgress;
import com.production.erp.view.PlanningView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PlanningServiceImp implements PlanningService {
    private final PlanningConverter converter;
    private final PlanningRepository repository;

    @Autowired
    public PlanningServiceImp(PlanningConverter converter, PlanningRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    @Override
    public PlanningModel createPlan(PlanningModel planningModel) {
        return converter.toModel(repository.save(converter.toEntity(planningModel)));
    }

    @Override
    public List<PlanningModel> plansList() {
        return converter.listToModels(repository.findAll());
    }

    @Override
    public PlanningModel planById(Long id) {
        return converter.toModel(repository.findById(id).map(PlanningEntity::new).orElseThrow(() -> new PlanningNotFoundException("Plan not found: " + id)));
    }

    @Override
    public PlanningModel updatePlan(PlanningModel planningModel, Long id) {
        return converter.toModel(repository.findById(id).map(p -> repository.save(converter.toEntity(planningModel))).orElseThrow(() -> new PlanningNotFoundException("Plan not found: " + id)));
    }

    @Override
    public String delete(Long id) {
        Optional<PlanningEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return "Deleted: " + optional.get();
        } else {
            throw new PlanningNotFoundException("Plan not found: " + id);
        }
    }

    @Override
    public List<PlanningView> planningView(String status, String filter) {
        if (filter == null || filter.equals(""))filter = "%%";
        return repository.planningView(status, filter);
    }

    @Override
    public List<PlanningView> planningViewITC(String filter) {
        if (filter == null || filter.equals(""))filter = "%%";
        return repository.planningViewITC(filter);
    }

    @Override
    public List<PlanningModel> planned(Date date, String status, String sku) {
        return converter.listToModels(repository.planned(date, status, sku));
    }

    @Override
    public List<PlanningModel> plannedDetail(Date date, String status, String sku) {
        return converter.listToModels(repository.plannedDetail(date, status, sku));
    }

    @Override
    public List<PlanProgress> planProgress(Date startDate, Date finishDate) {
        return repository.planProgress(startDate, finishDate);
    }

    @Override
    public boolean isAlreadyPlanned(Date date, String sku, String status) {
        Optional<PlanningEntity> optional = repository.isAlreadyPlanned(date, sku, status);
        return optional.isPresent();
    }

    @Transactional
    @Override
    public String deletePlan(Date date, String status, String sku) {
        repository.deletePlan(date, status, sku);
        return "Deleted plan";
    }

    @Override
    public PlanningModel findByDateAndStatusAndSkuAndOperator(Date date, String status, String sku, String operator) {
        return converter.toModel(repository.findByDateAndStatusAndSkuAndOperator(date, status, sku, operator));
    }
}
