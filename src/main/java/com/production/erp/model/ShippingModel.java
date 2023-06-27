package com.production.erp.model;

import java.sql.Date;
import java.util.Objects;

public class ShippingModel {
    private Long id;
    private Long order_number;
    private String tracking;
    private String courier;
    private String market;
    private Long imei;
    private Date date;
    private String operator;
    private double price;

    public ShippingModel() {
    }

    public ShippingModel(Long id, Long order_number, String tracking, String courier, String market, Long imei, Date date, String operator, double price) {
        this.id = id;
        this.order_number = order_number;
        this.tracking = tracking;
        this.courier = courier;
        this.market = market;
        this.imei = imei;
        this.date = date;
        this.operator = operator;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Long order_number) {
        this.order_number = order_number;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingModel that = (ShippingModel) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(id, that.id) && Objects.equals(order_number, that.order_number) && Objects.equals(tracking, that.tracking) && Objects.equals(courier, that.courier) && Objects.equals(market, that.market) && Objects.equals(imei, that.imei) && Objects.equals(date, that.date) && Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order_number, tracking, courier, market, imei, date, operator, price);
    }

    @Override
    public String toString() {
        return "ShippingModel{" +
                "id=" + id +
                ", order_number=" + order_number +
                ", tracking='" + tracking + '\'' +
                ", courier='" + courier + '\'' +
                ", market='" + market + '\'' +
                ", imei=" + imei +
                ", date=" + date +
                ", operator='" + operator + '\'' +
                ", price=" + price +
                '}';
    }
}
