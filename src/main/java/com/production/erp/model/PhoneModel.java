package com.production.erp.model;

import java.util.Objects;

public class PhoneModel {
    private Long imei;
    private int id_article;
    private String model;
    private int gb;
    private Long id_supplier;
    private String color;
    private String sku;
    private Long order_number;

    public PhoneModel() {
    }

    public PhoneModel(Long imei, int id_article, String model, int gb, Long id_supplier, String color, String sku, Long order_number) {
        this.imei = imei;
        this.id_article = id_article;
        this.model = model;
        this.gb = gb;
        this.id_supplier = id_supplier;
        this.color = color;
        this.sku = sku;
        this.order_number = order_number;
    }

    public PhoneModel(PhoneModel phone) {
        this.imei = phone.getImei();
        this.id_article = phone.getId_article();
        this.model = phone.getModel();
        this.gb = phone.getGb();
        this.id_supplier = phone.getId_supplier();
        this.color = phone.getColor();
        this.sku = phone.getSku();
        this.order_number = phone.getOrder_number();
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
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

    public Long getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Long id_supplier) {
        this.id_supplier = id_supplier;
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

    public Long getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Long order_number) {
        this.order_number = order_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneModel that = (PhoneModel) o;
        return id_article == that.id_article && gb == that.gb && Objects.equals(imei, that.imei) && Objects.equals(model, that.model) && Objects.equals(id_supplier, that.id_supplier) && Objects.equals(color, that.color) && Objects.equals(sku, that.sku) && Objects.equals(order_number, that.order_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imei, id_article, model, gb, id_supplier, color, sku, order_number);
    }

    @Override
    public String toString() {
        return "PhoneModel{" +
                "imei=" + imei +
                ", id_article=" + id_article +
                ", model='" + model + '\'' +
                ", gb=" + gb +
                ", id_supplier=" + id_supplier +
                ", color='" + color + '\'' +
                ", sku='" + sku + '\'' +
                ", order_number=" + order_number +
                '}';
    }
}
