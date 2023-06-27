package com.production.erp.model;

import java.sql.Blob;
import java.util.Objects;

public class PayModel {
    private Long number_order;
    private String payment_options;
    private boolean paid;

    public PayModel() {
    }

    public PayModel(Long number_order, String payment_options, boolean paid) {
        this.number_order = number_order;
        this.payment_options = payment_options;
        this.paid = paid;
    }

    public Long getNumber_order() {
        return number_order;
    }

    public void setNumber_order(Long number_order) {
        this.number_order = number_order;
    }

    public String getPayment_options() {
        return payment_options;
    }

    public void setPayment_options(String payment_options) {
        this.payment_options = payment_options;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayModel payModel = (PayModel) o;
        return paid == payModel.paid && Objects.equals(number_order, payModel.number_order) && Objects.equals(payment_options, payModel.payment_options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number_order, payment_options, paid);
    }

    @Override
    public String toString() {
        return "PayModel{" +
                "number_order=" + number_order +
                ", payment_options='" + payment_options + '\'' +
                ", paid=" + paid +
                '}';
    }
}
