package com.production.erp.converter;

import com.production.erp.entity.CartEntity;
import com.production.erp.entity.OrderEntity;
import com.production.erp.model.CartModel;
import com.production.erp.model.OrderModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartConverter {

    public CartModel toModel(CartEntity entity) {
        CartModel model = new CartModel();
        model.setId(entity.getId());
        model.setId_article(entity.getId_article());
        model.setId_supplier(entity.getId_supplier());
        model.setQty(entity.getQty());
        model.setPrice(entity.getPrice());
        model.setIva(entity.getIva());
        return model;
    }

    public List<CartModel> listToModels(List<CartEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public CartEntity toEntity(CartModel model) {
        CartEntity entity = new CartEntity();
        entity.setId(model.getId());
        entity.setId_article(model.getId_article());
        entity.setId_supplier(model.getId_supplier());
        entity.setQty(model.getQty());
        entity.setPrice(model.getPrice());
        entity.setIva(model.getIva());
        return entity;
    }

    public List<CartEntity> listToEntities(List<CartModel> modelList) {
        return modelList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
