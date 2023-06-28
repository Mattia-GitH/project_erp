package com.production.erp.importExport;

import java.util.Date;
import java.util.Objects;

public class OutputExportModel {
    private Long imei;
    private String color;
    private String grade;
    private int gb;
    private  String sku;
    private Date date;

    public OutputExportModel() {
    }

    public OutputExportModel(Long imei, String color, String grade, int gb, String sku, Date date) {
        this.imei = imei;
        this.color = color;
        this.grade = grade;
        this.gb = gb;
        this.sku = sku;
        this.date = date;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputExportModel that = (OutputExportModel) o;
        return gb == that.gb && Objects.equals(imei, that.imei) && Objects.equals(color, that.color) && Objects.equals(grade, that.grade) && Objects.equals(sku, that.sku) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imei, color, grade, gb, sku, date);
    }

    @Override
    public String toString() {
        return "OutputExportModel{" +
                "imei=" + imei +
                ", color='" + color + '\'' +
                ", grade='" + grade + '\'' +
                ", gb=" + gb +
                ", sku='" + sku + '\'' +
                ", date=" + date +
                '}';
    }
}
