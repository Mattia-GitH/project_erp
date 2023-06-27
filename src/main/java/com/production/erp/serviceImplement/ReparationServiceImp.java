package com.production.erp.serviceImplement;

import com.production.erp.converter.ReparationConverter;
import com.production.erp.entity.ReparationEntity;
import com.production.erp.exception.ReparationNotFoundException;
import com.production.erp.model.ReparationModel;
import com.production.erp.repository.ReparationRepository;
import com.production.erp.service.ReparationService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReparationServiceImp implements ReparationService {
    private final ReparationRepository repository;
    private final ReparationConverter converter;

    public ReparationServiceImp(ReparationRepository repository, ReparationConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public ReparationModel createReparation(ReparationModel reparationModel) {
        return converter.toModel(repository.save(converter.toEntity(reparationModel)));
    }

    @Override
    public List<ReparationModel> reparationsList() {
        return converter.listToModels(repository.findAll());
    }

    @Override
    public ReparationModel reparationById(Long id) {
        Optional<ReparationEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            return converter.toModel(optional.get());
        } else {
            throw new ReparationNotFoundException("Not found " + id);
        }
    }

    @Override
    public ReparationModel updateArticle(ReparationModel ReparationModel, Long id) {
        Optional<ReparationEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            ReparationEntity update = new ReparationEntity(optional.get().getId(), optional.get().getImei(), optional.get().getDate(), optional.get().getOperator(), optional.get().getTl(), optional.get().getComponent());
            return converter.toModel(repository.save(update));
        } else {
            throw new ReparationNotFoundException("Not found " + id);
        }
    }

    @Override
    public String delete(Long id) {
        Optional<ReparationEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            return "Deleted: " + optional.get();
        } else {
            throw new ReparationNotFoundException("Not found " + id);
        }
    }

    @Override
    public List<ReparationModel> findByImeiAndDateAfter(Long imei, Date date) {
        return converter.listToModels(repository.findByImeiAndDateAfter(imei, date));
    }
}
