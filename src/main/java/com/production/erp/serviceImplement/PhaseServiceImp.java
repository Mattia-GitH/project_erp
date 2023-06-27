package com.production.erp.serviceImplement;

import com.production.erp.converter.PhasesConverter;
import com.production.erp.model.PhasesModel;
import com.production.erp.repository.PhaseRepository;
import com.production.erp.service.PhaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhaseServiceImp implements PhaseService {
    private final PhasesConverter converter;
    private final PhaseRepository repository;

    public PhaseServiceImp(PhasesConverter converter, PhaseRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    @Override
    public List<PhasesModel> phases() {
        return converter.listToModels(repository.findAll());
    }
}
