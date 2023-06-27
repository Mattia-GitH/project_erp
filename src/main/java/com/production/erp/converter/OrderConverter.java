package com.production.erp.converter;

import com.production.erp.entity.OrderEntity;
import com.production.erp.model.OrderModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderConverter {
    public OrderModel toModel(OrderEntity entity) {
        OrderModel model = new OrderModel();
        model.setId(entity.getId());
        model.setId_article(entity.getId_article());
        model.setId_supplier(entity.getId_supplier());
        model.setQty(entity.getQty());
        model.setInit_qty(entity.getInit_qty());
        model.setDate(entity.getDate());
        model.setDate_purchase(entity.getDate_purchase());
        model.setPrice(entity.getPrice());
        model.setIva(entity.getIva());
        model.setCourier(entity.getCourier());
        model.setTracking(entity.getTracking());
        model.setNumber_order(entity.getOrder_number());
        model.setSup_order_number(entity.getSup_order_number());
        return model;
    }

    public List<OrderModel> listToModels(List<OrderEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public OrderEntity toEntity(OrderModel model) {
        OrderEntity entity = new OrderEntity();
        entity.setId(model.getId());
        entity.setId_article(model.getId_article());
        entity.setId_supplier(model.getId_supplier());
        entity.setQty(model.getQty());
        entity.setInit_qty(model.getInit_qty());
        entity.setDate(model.getDate());
        entity.setDate_purchase(model.getDate_purchase());
        entity.setPrice(model.getPrice());
        entity.setIva(model.getIva());
        entity.setCourier(model.getCourier());
        entity.setTracking(model.getTracking());
        entity.setOrder_number(model.getNumber_order());
        entity.setSup_order_number(entity.getSup_order_number());
        return entity;
    }

    public List<OrderEntity> listToEntities(List<OrderModel> modelList) {
        return modelList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
