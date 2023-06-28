package com.production.erp.container;

import com.production.erp.model.BatteryModel;
import com.production.erp.model.PolishModel;

import java.util.List;

public class PolishContainer {
    public List<PolishModel> polishList;

    public List<PolishModel> getPolishList() {
        return polishList;
    }

    public void setPolishList(List<PolishModel> polishList) {
        this.polishList = polishList;
    }
}
