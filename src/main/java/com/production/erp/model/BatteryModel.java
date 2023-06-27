package com.production.erp.model;

import java.util.Date;
import java.util.Objects;

public class BatteryModel {
    private Long id;
    private Long imei;
    private int soh;
    private int cycles;
    private boolean replace;
    private Date date;

    public BatteryModel() {
    }

    public BatteryModel(Long imei, Date date) {
        this.imei = imei;
        this.date = date;
    }

    public BatteryModel(Long id, Long imei, int soh, int cycles, boolean replace, Date date) {
        this.id = id;
        this.imei = imei;
        this.soh = soh;
        this.cycles = cycles;
        this.replace = replace;
        this.date = date;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public int getSoh() {
        return soh;
    }

    public void setSoh(int soh) {
        this.soh = soh;
    }

    public int getCycles() {
        return cycles;
    }

    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    public boolean isReplace() {
        return replace;
    }

    public void setReplace(boolean replace) {
        this.replace = replace;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BatteryModel that = (BatteryModel) o;
        return soh == that.soh && cycles == that.cycles && replace == that.replace && Objects.equals(id, that.id) && Objects.equals(imei, that.imei) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imei, soh, cycles, replace, date);
    }

    @Override
    public String toString() {
        return "BatteryModel{" +
                "id=" + id +
                ", imei=" + imei +
                ", soh=" + soh +
                ", cycles=" + cycles +
                ", replace=" + replace +
                ", date=" + date +
                '}';
    }
}
