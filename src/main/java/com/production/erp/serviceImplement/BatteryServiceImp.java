package com.production.erp.serviceImplement;

import com.production.erp.converter.BatteryConverter;
import com.production.erp.entity.BatteryEntity;
import com.production.erp.exception.BatteryNotFoundException;
import com.production.erp.model.BatteryModel;
import com.production.erp.repository.BatteryRepository;
import com.production.erp.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatteryServiceImp implements BatteryService {
    private final BatteryRepository repository;
    private final BatteryConverter converter;

    @Autowired
    public BatteryServiceImp(BatteryRepository repository, BatteryConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public BatteryModel createBattery(BatteryModel batteryModel) {
        BatteryEntity toSave = repository.save(converter.toEntity(batteryModel));
        return converter.toModel(toSave);
    }

    @Override
    public List<BatteryModel> listBatteries() {
        List<BatteryEntity> batteryEntities = repository.findAll();
        return converter.listToModels(batteryEntities);
    }

    @Override
    public BatteryModel batteryByImei(Long imei) {
        Optional<BatteryEntity> optional = repository.findById(imei);
        if (optional.isPresent()) {
            return converter.toModel(optional.get());
        } else {
            throw new BatteryNotFoundException("Battery not found: " + imei);
        }
    }

    @Override
    public BatteryModel updateBattery(BatteryModel batteryModel, Long imei) {
        Optional<BatteryEntity> optional = repository.findById(imei);
        if (optional.isPresent()) {
            BatteryEntity update = optional.get();
            update.setImei(batteryModel.getImei());
            update.setSoh(batteryModel.getSoh());
            update.setCycles(batteryModel.getCycles());
            update.setReplace(batteryModel.isReplace());
            update.setDate(batteryModel.getDate());
            repository.save(update);
            return converter.toModel(update);
        } else {
            throw new BatteryNotFoundException("Battery not found: " + imei);
        }
    }

    @Override
    public String delete(Long imei) {
        Optional<BatteryEntity> optional = repository.findById(imei);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return "Battery deleted: " + optional.get();
        } else {
            throw new BatteryNotFoundException("Battery not found: " + imei);
        }
    }

    public boolean isPresent(Long imei){
        Optional<BatteryEntity> optional = repository.findById(imei);
        return optional.isPresent();
    }

    @Override
    public BatteryModel findFirstByImeiOrderByDateDesc(Long imei) {
        BatteryEntity entity = repository.findFirstByImeiOrderByDateDesc(imei);
        if (entity != null){
            return converter.toModel(entity);
        } else {
            BatteryModel model = new BatteryModel();
            model.setImei(imei);
            return model;
        }
    }
}
