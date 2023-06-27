package com.production.erp.entity;

import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.sql.Blob;
import java.util.Objects;

@Entity
@Table(name = "PAY_TBL")
public class PayEntity {

    @Id
    @Column(name = "NUMBER_ORDER")
    private Long number_order;

    @Column(name = "PAID")
    private boolean paid;

    @Column(name = "PAYMENT_OPTIONS")
    private String payment_options;

    public PayEntity() {
    }

    public PayEntity(Long number_order, boolean paid, String payment_options) {
        this.number_order = number_order;
        this.paid = paid;
        this.payment_options = payment_options;
    }

    public Long getNumber_order() {
        return number_order;
    }

    public void setNumber_order(Long number_order) {
        this.number_order = number_order;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getPayment_options() {
        return payment_options;
    }

    public void setPayment_options(String payment_options) {
        this.payment_options = payment_options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayEntity entity = (PayEntity) o;
        return paid == entity.paid && Objects.equals(number_order, entity.number_order) && Objects.equals(payment_options, entity.payment_options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number_order, paid, payment_options);
    }

    @Override
    public String toString() {
        return "PayEntity{" +
                "number_order=" + number_order +
                ", paid=" + paid +
                ", payment_options='" + payment_options + '\'' +
                '}';
    }
}
