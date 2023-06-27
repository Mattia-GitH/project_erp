package com.production.erp.service;

import com.production.erp.model.ShippingModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShippingService {
    ShippingModel createShipping(ShippingModel model);

    List<ShippingModel> findByImei(Long imei);

    ShippingModel findById(Long id);

    String delete(Long id);

    ShippingModel findLastShippingByImei(Long imei);
}
