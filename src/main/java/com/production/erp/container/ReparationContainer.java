package com.production.erp.container;

import com.production.erp.model.ReparationModel;

import java.time.LocalTime;
import java.util.List;

public class ReparationContainer {
    private List<ReparationModel> reparations;
    private String send_to;
    private String seconds;
    private String mins;
    private String hours;

    public List<ReparationModel> getReparations() {
        return reparations;
    }

    public void setReparations(List<ReparationModel> reparations) {
        this.reparations = reparations;
    }

    public String getSend_to() {
        return send_to;
    }

    public void setSend_to(String send_to) {
        this.send_to = send_to;
    }

    public String getSeconds() {
        return seconds;
    }

    public void setSeconds(String seconds) {
        this.seconds = seconds;
    }

    public String getMins() {
        return mins;
    }

    public void setMins(String mins) {
        this.mins = mins;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
