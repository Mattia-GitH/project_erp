package com.production.erp.model;

import java.util.Date;
import java.util.Objects;

public class PlanningPreviewModel {
    private Long id;
    private Date date;
    private String sku;
    private int qty;
    private String status;
    private String operator;

    public PlanningPreviewModel() {
    }

    public PlanningPreviewModel(Long id, Date date, String sku, int qty, String status, String operator) {
        this.id = id;
        this.date = date;
        this.sku = sku;
        this.qty = qty;
        this.status = status;
        this.operator = operator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanningPreviewModel that = (PlanningPreviewModel) o;
        return qty == that.qty && Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(sku, that.sku) && Objects.equals(status, that.status) && Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, sku, qty, status, operator);
    }

    @Override
    public String toString() {
        return "PlanningPreviewModel{" +
                "id=" + id +
                ", date=" + date +
                ", sku='" + sku + '\'' +
                ", qty=" + qty +
                ", status='" + status + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
