package com.production.erp.container;

import com.production.erp.model.BatteryModel;

import java.util.List;

public class BatteryContainer {
    public List<BatteryModel> batteryList;

    public List<BatteryModel> getBatteryList() {
        return batteryList;
    }

    public void setBatteryList(List<BatteryModel> batteryList) {
        this.batteryList = batteryList;
    }
}
