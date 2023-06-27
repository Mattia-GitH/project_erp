package com.production.erp.converter;

import com.production.erp.entity.PhoneEntity;
import com.production.erp.model.PhoneModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhoneConverter {
    public PhoneModel toModel(PhoneEntity entity){
        PhoneModel model = new PhoneModel();
        model.setImei(entity.getImei());
        model.setId_article(entity.getId_article());
        model.setId_supplier(entity.getId_supplier());
        model.setModel(entity.getModel());
        model.setGb(entity.getGb());
        model.setColor(entity.getColor());
        model.setSku(entity.getSku());
        model.setOrder_number(entity.getOrder_number());
        return model;
    }

    public PhoneEntity toEntity(PhoneModel model){
        PhoneEntity entity = new PhoneEntity();
        entity.setImei(model.getImei());
        entity.setId_article(model.getId_article());
        entity.setId_supplier(model.getId_supplier());
        entity.setModel(model.getModel());
        entity.setGb(model.getGb());
        entity.setColor(model.getColor());
        entity.setSku(model.getSku());
        entity.setOrder_number(model.getOrder_number());
        return entity;
    }

    public List<PhoneModel> listToModels(List<PhoneEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<PhoneEntity> listToEntities(List<PhoneModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
