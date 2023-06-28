package com.production.erp.model;

import java.util.Objects;

public class GradeModel {
    private Long id;
    private Long imei;
    private String grade_sup;
    private String grade_check;
    private String operator;
    private String phase;

    public GradeModel() {
    }

    public GradeModel(Long id, Long imei, String grade_sup, String grade_check, String operator, String phase) {
        this.id = id;
        this.imei = imei;
        this.grade_sup = grade_sup;
        this.grade_check = grade_check;
        this.operator = operator;
        this.phase = phase;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeModel that = (GradeModel) o;
        return Objects.equals(id, that.id) && Objects.equals(imei, that.imei) && Objects.equals(grade_sup, that.grade_sup) && Objects.equals(grade_check, that.grade_check) && Objects.equals(operator, that.operator) && Objects.equals(phase, that.phase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imei, grade_sup, grade_check, operator, phase);
    }

    @Override
    public String toString() {
        return "GradeModel{" +
                "id=" + id +
                ", imei=" + imei +
                ", grade_sup='" + grade_sup + '\'' +
                ", grade_check='" + grade_check + '\'' +
                ", operator='" + operator + '\'' +
                ", phase='" + phase + '\'' +
                '}';
    }
}
