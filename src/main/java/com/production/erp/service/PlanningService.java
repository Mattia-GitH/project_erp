package com.production.erp.service;

import com.production.erp.entity.PlanningEntity;
import com.production.erp.model.PlanningModel;
import com.production.erp.view.PlanProgress;
import com.production.erp.view.PlanningView;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface PlanningService {
    PlanningModel createPlan(PlanningModel planningModel);

    List<PlanningModel> plansList();

    PlanningModel planById(Long id);

    PlanningModel updatePlan(PlanningModel planningModel, Long id);

    String delete(Long id);

    List<PlanningView> planningView(String status, String filter);

    List<PlanningView> planningViewITC(String filter);

    List<PlanningModel> planned(Date date, String status, String sku);

    List<PlanningModel> plannedDetail(Date date, String status, String sku);

    List<PlanProgress> planProgress(Date startDate, Date finishDate);

    boolean isAlreadyPlanned(Date date, String sku, String status);

    String deletePlan(Date date, String status, String sku);

    PlanningModel findByDateAndStatusAndSkuAndOperator(Date date, String status, String sku, String operator);
}
