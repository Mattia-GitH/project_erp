package com.production.erp.serviceImplement;

import com.production.erp.converter.ComponentConverter;
import com.production.erp.entity.ComponentEntity;
import com.production.erp.model.ComponentModel;
import com.production.erp.repository.ComponentRepository;
import com.production.erp.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentServiceImp implements ComponentService {
    private final ComponentRepository repository;
    private final ComponentConverter converter;

    @Autowired
    public ComponentServiceImp(ComponentRepository repository, ComponentConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public ComponentModel findBySku(String sku) {
        Optional<ComponentEntity> componentEntity = repository.findBySku(sku);
        return componentEntity.map(converter::toModel).orElse(null);
    }

    @Override
    public List<ComponentModel> componentsList() {
        return converter.listToModels(repository.findAll());
    }

    @Transactional
    @Override
    public void updateQty(String sku, int qty) {
        repository.updateQty(sku, qty);
    }
}
