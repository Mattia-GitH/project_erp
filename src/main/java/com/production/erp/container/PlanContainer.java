package com.production.erp.container;

import com.production.erp.model.PlanningModel;

import java.util.Date;
import java.util.List;

public class PlanContainer {
    private List<PlanningModel> planList;
    private Date date;

    public List<PlanningModel> getPlanList() {
        return planList;
    }

    public void setPlanList(List<PlanningModel> planList) {
        this.planList = planList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
