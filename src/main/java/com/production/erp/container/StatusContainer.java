package com.production.erp.container;

import com.production.erp.model.StatusModel;

import java.util.List;

public class StatusContainer {
    public List<StatusModel> statusList;

    public List<StatusModel> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<StatusModel> statusList) {
        this.statusList = statusList;
    }
}
