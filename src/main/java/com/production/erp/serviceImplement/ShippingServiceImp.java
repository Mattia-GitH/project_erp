package com.production.erp.serviceImplement;

import com.production.erp.converter.ShippingConverter;
import com.production.erp.entity.ShippingEntity;
import com.production.erp.exception.ShippingNotFoundException;
import com.production.erp.model.ShippingModel;
import com.production.erp.repository.ShippingRepository;
import com.production.erp.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingServiceImp implements ShippingService {
    private final ShippingRepository repository;
    private final ShippingConverter converter;

    @Autowired
    public ShippingServiceImp(ShippingRepository repository, ShippingConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public ShippingModel createShipping(ShippingModel model) {
        return converter.toModel(repository.save(converter.toEntity(model)));
    }

    @Override
    public List<ShippingModel> findByImei(Long imei) {
        Optional<List<ShippingEntity>> shippingEntities = repository.findByImei(imei);
        if (shippingEntities.isPresent()){
            return converter.listToModels(shippingEntities.get());
        } else {
         throw new ShippingNotFoundException("Shipping not found: " + imei);
        }
    }

    @Override
    public ShippingModel findById(Long id) {
        return converter.toModel(repository.findById(id).map(ShippingEntity::new).orElseThrow(() -> new ShippingNotFoundException("Shipping not found :" + id)));
    }

    @Override
    public String delete(Long id) {
        Optional<ShippingEntity> toDelete = repository.findById(id);
        if (toDelete.isPresent()){
            repository.delete(toDelete.get());
            return "Deleted :" + id;
        } else {
            throw new ShippingNotFoundException("Not found shipping to delete: " + id);
        }
    }

    @Override
    public ShippingModel findLastShippingByImei(Long imei) {
        return converter.toModel(repository.findFirstByImeiOrderByDateDesc(imei));
    }
}
