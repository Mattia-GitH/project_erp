package com.production.erp.serviceImplement;

import com.production.erp.converter.PolishConverter;
import com.production.erp.entity.PolishEntity;
import com.production.erp.exception.PolishNotFoundException;
import com.production.erp.model.PolishModel;
import com.production.erp.repository.PolishRepository;
import com.production.erp.service.PolishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolishServiceImp implements PolishService {
    private final PolishConverter converter;
    private final PolishRepository repository;

    @Autowired
    public PolishServiceImp(PolishConverter converter, PolishRepository repository) {
        this.converter = converter;
        this.repository = repository;
    }

    @Override
    public PolishModel createPolish(PolishModel polishModel) {
        return converter.toModel(repository.save(converter.toEntity(polishModel)));
    }

    @Override
    public List<PolishModel> listPolish() {
        return converter.listToModels(repository.findAll());
    }

    @Override
    public PolishModel polishByImei(Long imei) {
        Optional<PolishEntity> optional = repository.findFirstByImeiOrderByIdDesc(imei);
        if (optional.isPresent()){
            return converter.toModel(optional.get());
        } else {
            throw new PolishNotFoundException("Polish not found. IMEI: " + imei);
        }
    }

    @Override
    public List<PolishModel> allPolishByImei(Long imei) {
        return converter.listToModels(repository.findByImei(imei));
    }
}
