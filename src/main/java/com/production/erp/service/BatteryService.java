package com.production.erp.service;

import com.production.erp.model.BatteryModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BatteryService {
    BatteryModel createBattery(BatteryModel batteryModel);

    List<BatteryModel> listBatteries();

    BatteryModel batteryByImei(Long imei);

    BatteryModel updateBattery(BatteryModel batteryModel, Long imei);

    String delete(Long imei);

    boolean isPresent(Long imei);

    BatteryModel findFirstByImeiOrderByDateDesc(Long imei);
}
