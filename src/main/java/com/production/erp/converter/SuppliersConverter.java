package com.production.erp.converter;

import com.production.erp.entity.SuppliersEntity;
import com.production.erp.model.SuppliersModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SuppliersConverter {
    public SuppliersModel toModel(SuppliersEntity entity){
        SuppliersModel model = new SuppliersModel();
        model.setId(entity.getId());
        model.setSupplier(entity.getSupplier());
        model.setProd_name(entity.getProd_name());
        model.setMail(entity.getMail());
        model.setPhone(entity.getPhone());
        model.setAddress(entity.getAddress());
        model.setRma(entity.isRma());
        return model;
    }

    public SuppliersEntity toEntity(SuppliersModel model){
        SuppliersEntity entity = new SuppliersEntity();
        entity.setId(model.getId());
        entity.setSupplier(model.getSupplier());
        entity.setProd_name(model.getProd_name());
        entity.setMail(model.getMail());
        entity.setPhone(model.getPhone());
        entity.setAddress(model.getAddress());
        entity.setRma(model.isRma());
        return entity;
    }

    public List<SuppliersModel> listToModels(List<SuppliersEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<SuppliersEntity> listToEntities(List<SuppliersModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
