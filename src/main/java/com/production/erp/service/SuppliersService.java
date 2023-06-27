package com.production.erp.service;

import com.production.erp.model.SuppliersModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SuppliersService {
    SuppliersModel createSupplier(SuppliersModel suppliersModel);

    List<SuppliersModel> listSuppliers();

    SuppliersModel supplierByImei(Long imei);

    SuppliersModel updateSupplier(SuppliersModel suppliersModel, Long imei);

    String delete(Long imei);

    boolean isPresent(Long imei);

    List<SuppliersModel> supplierList();

    List<SuppliersModel> supplierIdInCart();

    String supplierFromOrderNumber(Long order_number);
}
