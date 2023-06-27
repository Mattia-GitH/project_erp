package com.production.erp.importExport;

import java.util.Objects;

public class OutputExportModel {
    private Long imei;
    private String color;
    private String grade;

    public OutputExportModel() {
    }

    public OutputExportModel(Long imei, String color, String grade) {
        this.imei = imei;
        this.color = color;
        this.grade = grade;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputExportModel that = (OutputExportModel) o;
        return Objects.equals(imei, that.imei) && Objects.equals(color, that.color) && Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imei, color, grade);
    }

    @Override
    public String toString() {
        return "OutputExportModel{" +
                "imei=" + imei +
                ", color='" + color + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
