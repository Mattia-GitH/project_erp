package com.production.erp.view;

import java.util.Objects;

public class PlanningView {
    private Long qty;
    private String status;
    private String sku;
    private String model;
    private int gb;
    private String color;
    private String grade;

    public PlanningView() {
    }

    public PlanningView(Long qty, String status, String sku, String model, int gb, String color, String grade) {
        this.qty = qty;
        this.status = status;
        this.sku = sku;
        this.model = model;
        this.gb = gb;
        this.color = color;
        this.grade = grade;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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
        PlanningView that = (PlanningView) o;
        return qty == that.qty && gb == that.gb && Objects.equals(status, that.status) && Objects.equals(sku, that.sku) && Objects.equals(model, that.model) && Objects.equals(color, that.color) && Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qty, status, sku, model, gb, color, grade);
    }

    @Override
    public String toString() {
        return "PlanningView{" +
                "qty=" + qty +
                ", status='" + status + '\'' +
                ", sku='" + sku + '\'' +
                ", model='" + model + '\'' +
                ", gb=" + gb +
                ", color='" + color + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
