package com.production.erp.service;

import com.production.erp.model.PhasesModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhaseService {
    List<PhasesModel> phases();
}
