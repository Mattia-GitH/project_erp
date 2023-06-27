package com.production.erp.serviceImplement;

import com.production.erp.converter.SuppliersConverter;
import com.production.erp.entity.SuppliersEntity;
import com.production.erp.exception.StatusNotFoundException;
import com.production.erp.model.SuppliersModel;
import com.production.erp.repository.SuppliersRepository;
import com.production.erp.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImp implements SuppliersService {
    private final SuppliersRepository repository;
    private final SuppliersConverter converter;

    @Autowired
    public SupplierServiceImp(SuppliersRepository repository, SuppliersConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public SuppliersModel createSupplier(SuppliersModel suppliersModel) {
        SuppliersEntity toSave = repository.save(converter.toEntity(suppliersModel));
        return converter.toModel(toSave);
    }

    @Override
    public List<SuppliersModel> listSuppliers() {
        List<SuppliersEntity> entityList = repository.findAll();
        return converter.listToModels(entityList);
    }

    @Override
    public SuppliersModel supplierByImei(Long imei) {
        Optional<SuppliersEntity> optional = repository.findById(imei);
        if (optional.isPresent()) {
            return converter.toModel(optional.get());
        } else {
            throw new StatusNotFoundException("Supplier not found: " + imei);
        }
    }

    @Override
    public SuppliersModel updateSupplier(SuppliersModel suppliersModel, Long imei) {
        Optional<SuppliersEntity> optional = repository.findById(imei);
        if (optional.isPresent()) {
            SuppliersEntity update = optional.get();
            update.setId(suppliersModel.getId());
            update.setSupplier(suppliersModel.getSupplier());
            update.setProd_name(suppliersModel.getProd_name());
            update.setMail(suppliersModel.getMail());
            update.setPhone(suppliersModel.getPhone());
            update.setAddress(suppliersModel.getAddress());
            update.setRma(suppliersModel.isRma());
            repository.save(update);
            return converter.toModel(update);
        } else {
            throw new StatusNotFoundException("Supplier not found: " + imei);
        }
    }

    @Override
    public String delete(Long imei) {
        Optional<SuppliersEntity> optional = repository.findById(imei);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return "Supplier deleted: " + optional.get();
        } else {
            throw new StatusNotFoundException("Supplier not found: " + imei);
        }
    }

    public boolean isPresent(Long imei) {
        Optional<SuppliersEntity> optional = repository.findById(imei);
        return optional.isPresent();
    }

    @Override
    public List<SuppliersModel> supplierList() {
        return converter.listToModels(repository.supplierList());
    }

    @Override
    public List<SuppliersModel> supplierIdInCart() {
        return converter.listToModels(repository.supplierIdInCart());
    }

    @Override
    public String supplierFromOrderNumber(Long order_number) {
        return repository.supplierFromOrderNumber(order_number);
    }
}

