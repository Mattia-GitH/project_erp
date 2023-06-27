package com.production.erp.model;

import java.util.Objects;

public class GradeModel {
    private Long imei;
    private String grade_sup;
    private String grade_check;

    public GradeModel() {
    }

    public GradeModel(Long imei, String grade_sup, String grade_check) {
        this.imei = imei;
        this.grade_sup = grade_sup;
        this.grade_check = grade_check;
    }

    public GradeModel(Long imei, String grade_sup) {
        this.imei = imei;
        this.grade_sup = grade_sup;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public String getGrade_sup() {
        return grade_sup;
    }

    public void setGrade_sup(String grade_sup) {
        this.grade_sup = grade_sup;
    }

    public String getGrade_check() {
        return grade_check;
    }

    public void setGrade_check(String grade_check) {
        this.grade_check = grade_check;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeModel that = (GradeModel) o;
        return Objects.equals(imei, that.imei) && Objects.equals(grade_sup, that.grade_sup) && Objects.equals(grade_check, that.grade_check);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imei, grade_sup, grade_check);
    }

    @Override
    public String toString() {
        return "GradeModel{" +
                "imei=" + imei +
                ", grade_sup='" + grade_sup + '\'' +
                ", grade_check='" + grade_check + '\'' +
                '}';
    }
}
