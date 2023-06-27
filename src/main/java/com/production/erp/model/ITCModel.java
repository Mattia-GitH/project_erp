package com.production.erp.model;

import java.util.Date;
import java.util.Objects;

public class ITCModel {
    private Date date;
    private String operator;
    private Long imei;
    private String model;
    private int gb;
    private String status;

    public ITCModel() {
    }

    public ITCModel(Date date, String operator, Long imei, String model, int gb, String status) {
        this.date = date;
        this.operator = operator;
        this.imei = imei;
        this.model = model;
        this.gb = gb;
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ITCModel itcModel = (ITCModel) o;
        return gb == itcModel.gb && Objects.equals(date, itcModel.date) && Objects.equals(operator, itcModel.operator) && Objects.equals(imei, itcModel.imei) && Objects.equals(model, itcModel.model) && Objects.equals(status, itcModel.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, operator, imei, model, gb, status);
    }

    @Override
    public String toString() {
        return "ITCModel{" +
                "date=" + date +
                ", operator='" + operator + '\'' +
                ", imei=" + imei +
                ", model='" + model + '\'' +
                ", gb=" + gb +
                ", status='" + status + '\'' +
                '}';
    }
}
