package com.production.erp.serviceImplement;

import com.production.erp.converter.PhoneConverter;
import com.production.erp.entity.PhoneEntity;
import com.production.erp.exception.PhoneNotFoundException;
import com.production.erp.importExport.ITCExportModel;
import com.production.erp.importExport.OutputExportModel;
import com.production.erp.importExport.ShippingExportModel;
import com.production.erp.view.ITCView;
import com.production.erp.model.PhoneModel;
import com.production.erp.repository.PhoneRepository;
import com.production.erp.service.PhoneService;
import com.production.erp.view.PhoneInfo;
import com.production.erp.view.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImp implements PhoneService {
    private final PhoneRepository repository;
    private final PhoneConverter converter;

    @Autowired
    public PhoneServiceImp(PhoneRepository repository, PhoneConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<PhoneModel> listPhones() {
        List<PhoneEntity> entityList = repository.findAll();
        return converter.listToModels(entityList);
    }

    @Override
    public PhoneModel phoneByImei(Long imei) {
        Optional<PhoneEntity> optional = repository.findById(imei);
        if (optional.isPresent()) {
            return converter.toModel(optional.get());
        } else {
            throw new PhoneNotFoundException("Phone not found: " + imei);
        }
    }

    @Override
    public PhoneModel updatePhone(PhoneModel phoneModel, Long imei) {
        Optional<PhoneEntity> optional = repository.findById(imei);
        if (optional.isPresent()) {
            PhoneEntity update = optional.get();
            update.setImei(phoneModel.getImei());
            update.setId_article(phoneModel.getId_article());
            update.setId_supplier(phoneModel.getId_supplier());
            update.setColor(phoneModel.getColor());
            update.setModel(phoneModel.getModel());
            update.setGb(phoneModel.getGb());
            update.setSku(phoneModel.getSku());
            repository.save(update);
            return converter.toModel(update);
        } else {
            throw new PhoneNotFoundException("Phone not found: " + imei);
        }
    }

    @Override
    public String delete(Long imei) {
        Optional<PhoneEntity> optional = repository.findById(imei);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return "Phone deleted: " + optional.get();
        } else {
            throw new PhoneNotFoundException("Phone not found: " + imei);
        }
    }


    @Override
    public PhoneModel createPhone(PhoneModel phoneModel) {
        Optional<PhoneEntity> optional = repository.findById(phoneModel.getImei());
        if (optional.isPresent()) {
            System.out.println("Already exist");
            return phoneModel;
        } else {
            PhoneEntity toSave = repository.save(converter.toEntity(phoneModel));
            return converter.toModel(toSave);
        }
    }

    @Override
    public boolean phoneAlreadyExist(PhoneModel phoneModel) {
        Optional<PhoneEntity> optional = repository.findById(phoneModel.getImei());
        return optional.isPresent();
    }

    public boolean isPresent(Long imei){
        Optional<PhoneEntity> optional = repository.findById(imei);
        return optional.isPresent();
    }

    @Override
    public List<ITCView> itcView() {
        return repository.itcView();
    }

    @Override
    public List<ITCView> itcViewFilter(String supplier) {
        return repository.itcViewFilter(supplier);
    }

    @Override
    public List<ITCView> testFilter(String supplier) {
        return repository.testFilter(supplier);
    }

    @Override
    public String getGradeSup(Long imei) {
        return repository.getGradeSup(imei);
    }

    @Override
    public PhoneModel findByImei(Long imei) {
        return converter.toModel(repository.findByImei(imei).map(PhoneEntity::new).orElseThrow(() -> new PhoneNotFoundException("Phone not found: " + imei)));
    }

    @Override
    public List<Long> orderNumberData() {
        return repository.orderNumberData();
    }

    @Override
    public List<String> skuData() {
        return repository.skuData();
    }

    @Override
    public List<String> modelData() {
        return repository.modelData();
    }

    @Override
    public List<String> colorData() {
        return repository.colorData();
    }

    @Override
    public List<String> gradeData() {
        return repository.gradeData();
    }

    @Override
    public List<String> supplierData() {
        return repository.supplierData();
    }

    @Override
    public List<Long> gbData() {
        return repository.gbData().stream().mapToLong(Integer::longValue).boxed().collect(Collectors.toList());
    }

    @Override
    public List<Warehouse> warehouseViewFiltered(Long order_number, String sku, String model, String color, String grade, String supplier, int gb, String actual_status, Long imei) {
        return repository.warehouseViewFiltered(order_number, sku, model, color, grade, supplier, gb, imei);
    }

    @Override
    public List<Warehouse> warehouseViewSkuFiltered(String sku, String model, int gb, String color) {
        return repository.warehouseViewSkuFiltered(sku, model, gb, color);
    }

    @Override
    public List<Warehouse> warehouseViewFindSKUFiltered(String sku, Long order_number, String model, int gb, String grade, String supplier, String actual_status, Long imei) {
        return repository.warehouseViewFindSKUFiltered(sku, order_number, model, gb, grade, supplier, actual_status, imei);
    }

    @Override
    public PhoneInfo phoneInfos(Long imei) {
        return repository.phoneInfos(imei);
    }

    @Transactional
    @Override
    public PhoneModel updateSku(Long imei, String sku) {
        Optional<PhoneEntity> optional = repository.findByImei(imei);
        if (optional.isPresent()){
            repository.updateSku(imei, sku);
            return converter.toModel(optional.get());
        } else {
            throw new PhoneNotFoundException("imei " + imei);
        }
    }

    @Override
    public List<ITCExportModel> phoneExport(java.util.Date date, java.util.Date date2) {
        return repository.phoneExport(date, date2);
    }

    @Override
    public List<OutputExportModel> outputExport(Date date) {
        return repository.outputExport(date);
    }

    @Override
    public List<ShippingExportModel> shippingExporter() {
        return repository.shippingExport();
    }

    @Override
    public List<Warehouse> outputHomeView(String sku, String model, int gb, String color) {
        return repository.outputHomeView(sku, model, gb, color);
    }

    @Override
    public List<Warehouse> outputSkuView(String sku, Long order_number, String supplier, Long imei) {
        return repository.outputSkuView(sku, order_number, supplier, imei);
    }

    @Override
    public List<ITCView> test() {
        return repository.test();
    }

}
