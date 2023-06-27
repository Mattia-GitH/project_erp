package com.production.erp.converter;

import com.production.erp.entity.PayEntity;
import com.production.erp.model.PayModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PayConverter {
    public PayModel toModel(PayEntity entity){
        PayModel model = new PayModel();
        model.setNumber_order(entity.getNumber_order());
        model.setPaid(entity.isPaid());
        model.setPayment_options(entity.getPayment_options());
        return model;
    }

    public List<PayModel> listToModels(List<PayEntity> entityList){
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public PayEntity toEntity(PayModel model){
        PayEntity entity = new PayEntity();
        entity.setNumber_order(model.getNumber_order());
        entity.setPaid(model.isPaid());
        entity.setPayment_options(model.getPayment_options());
        return entity;
    }

    public List<PayEntity> listToEntities(List<PayModel> entityList){
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
