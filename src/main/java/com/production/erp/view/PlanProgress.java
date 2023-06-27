package com.production.erp.view;

import java.util.Date;
import java.util.Objects;

public class PlanProgress {
    private Date date;
    private String sku;
    private Long done;
    private String status;
    private String operator;

    public PlanProgress() {
    }

    public PlanProgress(Date date, String sku, Long done, String status, String operator) {
        this.date = date;
        this.sku = sku;
        this.done = done;
        this.status = status;
        this.operator = operator;
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

    public Long getDone() {
        return done;
    }

    public void setDone(Long done) {
        this.done = done;
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
        PlanProgress that = (PlanProgress) o;
        return Objects.equals(date, that.date) && Objects.equals(sku, that.sku) && Objects.equals(done, that.done) && Objects.equals(status, that.status) && Objects.equals(operator, that.operator);
    }

    @Override
    public String toString() {
        return "PlanProgress{" +
                "date=" + date +
                ", sku='" + sku + '\'' +
                ", done=" + done +
                ", status='" + status + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, sku, done, status, operator);
    }
}
