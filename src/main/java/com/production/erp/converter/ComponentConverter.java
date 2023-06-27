package com.production.erp.converter;

import com.production.erp.entity.ComponentEntity;
import com.production.erp.model.ComponentModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ComponentConverter {
    public ComponentModel toModel(ComponentEntity entity){
        ComponentModel model = new ComponentModel();
        model.setId(entity.getId());
        model.setQty(entity.getQty());
        model.setSku(entity.getSku());

        return model;
    }

    public ComponentEntity toEntity(ComponentModel model){
        ComponentEntity entity = new ComponentEntity();
        entity.setId(model.getId());
        entity.setQty(model.getQty());
        entity.setSku(model.getSku());

        return entity;
    }

    public List<ComponentModel> listToModels(List<ComponentEntity> componentEntities) {
        return componentEntities.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<ComponentEntity> listToEntities(List<ComponentModel> componentModels) {
        return componentModels.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
