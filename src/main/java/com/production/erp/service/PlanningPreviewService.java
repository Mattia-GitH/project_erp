package com.production.erp.service;

import com.production.erp.model.PlanningPreviewModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanningPreviewService {
    PlanningPreviewModel createPlan(PlanningPreviewModel planningPreviewModel);

    List<PlanningPreviewModel> planList();

    PlanningPreviewModel planById(Long id);

    PlanningPreviewModel updatePlan(PlanningPreviewModel planningPreviewModel, Long id);

    String delete(Long id);

    String truncate();
}
