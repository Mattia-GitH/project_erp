package com.production.erp.service;

import com.production.erp.importExport.ITCExportModel;
import com.production.erp.importExport.OutputExportModel;
import com.production.erp.importExport.ShippingExportModel;
import com.production.erp.view.ITCView;
import com.production.erp.model.PhoneModel;
import com.production.erp.view.PhoneInfo;
import com.production.erp.view.Warehouse;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface PhoneService {
    PhoneModel createPhone(PhoneModel phoneModel);

    List<PhoneModel> listPhones();

    PhoneModel phoneByImei(Long imei);

    PhoneModel updatePhone(PhoneModel phoneModel, Long imei);

    String delete(Long imei);

    boolean phoneAlreadyExist(PhoneModel phoneModel);

    boolean isPresent(Long imei);

    List<ITCView> itcView();

    List<ITCView> itcViewFilter(String supplier);

    List<ITCView> test();

    List<ITCView> testFilter(String supplier);

    String getGradeSup(Long imei);

    PhoneModel findByImei(Long imei);

    List<Long> orderNumberData();

    List<String> skuData();

    List<String> modelData();

    List<String> colorData();

    List<String> gradeData();

    List<String> supplierData();

    List<Long> gbData();

    List<Warehouse> warehouseViewFiltered(Long order_number, String sku, String model, String color, String grade, String supplier, int gb, String actual_status, Long imei);

    List<Warehouse> warehouseViewSkuFiltered(String sku, String model, int gb, String color);

    List<Warehouse> warehouseViewFindSKUFiltered(String sku, Long order_number, String model, int gb, String grade, String supplier, String actual_status, Long imei);

    PhoneInfo phoneInfos(Long imei);

    PhoneModel updateSku(Long imei, String sku);

    List<ITCExportModel>phoneExport(java.util.Date date, java.util.Date date2);

    List<OutputExportModel> outputExport(Date date);

    List<ShippingExportModel> shippingExporter();

    List<Warehouse> outputHomeView(String sku, String model, int gb, String color);

    List<Warehouse> outputSkuView(String sku, Long order_number, String supplier, Long imei);

}
