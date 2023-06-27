package com.production.erp.view;

import java.util.Objects;

public class PhoneInfo {
    private Long order_number;
    private Long imei;
    private String model;
    private int gb;
    private String color;
    private String sku;
    private String prod_name;

    public PhoneInfo() {
    }

    public PhoneInfo(Long order_number, Long imei, String model, int gb, String color, String sku, String prod_name) {
        this.order_number = order_number;
        this.imei = imei;
        this.model = model;
        this.gb = gb;
        this.color = color;
        this.sku = sku;
        this.prod_name = prod_name;
    }

    public Long getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Long order_number) {
        this.order_number = order_number;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneInfo phoneInfo = (PhoneInfo) o;
        return gb == phoneInfo.gb && Objects.equals(order_number, phoneInfo.order_number) && Objects.equals(imei, phoneInfo.imei) && Objects.equals(model, phoneInfo.model) && Objects.equals(color, phoneInfo.color) && Objects.equals(sku, phoneInfo.sku) && Objects.equals(prod_name, phoneInfo.prod_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_number, imei, model, gb, color, sku, prod_name);
    }

    @Override
    public String toString() {
        return "PhoneInfo{" +
                "order_number=" + order_number +
                ", imei=" + imei +
                ", model='" + model + '\'' +
                ", gb=" + gb +
                ", color='" + color + '\'' +
                ", sku='" + sku + '\'' +
                ", prod_name='" + prod_name + '\'' +
                '}';
    }
}
