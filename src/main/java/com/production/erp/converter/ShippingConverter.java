package com.production.erp.converter;

import com.production.erp.entity.ShippingEntity;
import com.production.erp.model.ShippingModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShippingConverter {
    public ShippingModel toModel(ShippingEntity entity){
        ShippingModel model = new ShippingModel();
        model.setId(entity.getId());
        model.setCourier(entity.getCourier());
        model.setTracking(entity.getTracking());
        model.setImei(entity.getImei());
        model.setOrder_number(entity.getOrder_number());
        model.setDate(entity.getDate());
        model.setMarket(entity.getMarket());
        model.setOperator(entity.getOperator());
        model.setPrice(entity.getPrice());

        return model;
    }

    public ShippingEntity toEntity(ShippingModel model){
        ShippingEntity entity = new ShippingEntity();
        entity.setId(model.getId());
        entity.setCourier(model.getCourier());
        entity.setTracking(model.getTracking());
        entity.setImei(model.getImei());
        entity.setOrder_number(model.getOrder_number());
        entity.setDate(model.getDate());
        entity.setMarket(model.getMarket());
        entity.setOperator(model.getOperator());
        entity.setPrice(model.getPrice());

        return entity;
    }

    public List<ShippingModel> listToModels(List<ShippingEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<ShippingEntity> listToEntities(List<ShippingModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
