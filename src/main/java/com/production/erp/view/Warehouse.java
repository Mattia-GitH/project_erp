package com.production.erp.view;

import java.util.Date;
import java.util.Objects;

public class Warehouse {
    private String operator;
    private String actual_status;
    private String send_to;
    private Date date;
    private int id_article;
    private Long id_supplier;
    private Long order_number;
    private String sku;
    private Long imei;
    private String model;
    private int gb;
    private String color;
    private String grade;
    private String supplier;
    private Long phoneQty;
    private String tracking;

    public Warehouse() {
    }

    public Warehouse(int id_article, Long id_supplier, Long order_number, String sku, Long imei, String model, int gb, String color, String grade, String supplier) {
        this.id_article = id_article;
        this.id_supplier = id_supplier;
        this.order_number = order_number;
        this.sku = sku;
        this.imei = imei;
        this.model = model;
        this.gb = gb;
        this.color = color;
        this.grade = grade;
        this.supplier = supplier;
    }

    public Warehouse(int id_article, String sku, String model, int gb, String color, Long phoneQty) {
        this.id_article = id_article;
        this.sku = sku;
        this.model = model;
        this.gb = gb;
        this.color = color;
        this.phoneQty = phoneQty;
    }

    public Warehouse(int id_article, String sku, String model, int gb, String color) {
        this.id_article = id_article;
        this.sku = sku;
        this.model = model;
        this.gb = gb;
        this.color = color;
    }

    public Warehouse(String operator, String actual_status, String send_to, Date date, int id_article, Long id_supplier, Long order_number, String sku, Long imei, String model, int gb, String color, String grade, String supplier) {
        this.operator = operator;
        this.actual_status = actual_status;
        this.send_to = send_to;
        this.date = date;
        this.id_article = id_article;
        this.id_supplier = id_supplier;
        this.order_number = order_number;
        this.sku = sku;
        this.imei = imei;
        this.model = model;
        this.gb = gb;
        this.color = color;
        this.grade = grade;
        this.supplier = supplier;
    }

    public Warehouse(String sku, String model, int gb, String color, Long phoneQty) {
        this.sku = sku;
        this.model = model;
        this.gb = gb;
        this.color = color;
        this.phoneQty = phoneQty;
    }

    public Warehouse(Long order_number, String sku, Long imei, String model, int gb, String color, String supplier) {
        this.order_number = order_number;
        this.sku = sku;
        this.imei = imei;
        this.model = model;
        this.gb = gb;
        this.color = color;
        this.supplier = supplier;
    }

    public Warehouse(Long order_number, String sku, Long imei, String model, int gb, String color, String supplier, String grade) {
        this.order_number = order_number;
        this.sku = sku;
        this.imei = imei;
        this.model = model;
        this.gb = gb;
        this.color = color;
        this.grade = grade;
        this.supplier = supplier;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getActual_status() {
        return actual_status;
    }

    public void setActual_status(String actual_status) {
        this.actual_status = actual_status;
    }

    public String getSend_to() {
        return send_to;
    }

    public void setSend_to(String send_to) {
        this.send_to = send_to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public Long getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Long id_supplier) {
        this.id_supplier = id_supplier;
    }

    public Long getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Long order_number) {
        this.order_number = order_number;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Long getPhoneQty() {
        return phoneQty;
    }

    public void setPhoneQty(Long phoneQty) {
        this.phoneQty = phoneQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return id_article == warehouse.id_article && gb == warehouse.gb && Objects.equals(operator, warehouse.operator) && Objects.equals(actual_status, warehouse.actual_status) && Objects.equals(send_to, warehouse.send_to) && Objects.equals(date, warehouse.date) && Objects.equals(id_supplier, warehouse.id_supplier) && Objects.equals(order_number, warehouse.order_number) && Objects.equals(sku, warehouse.sku) && Objects.equals(imei, warehouse.imei) && Objects.equals(model, warehouse.model) && Objects.equals(color, warehouse.color) && Objects.equals(grade, warehouse.grade) && Objects.equals(supplier, warehouse.supplier) && Objects.equals(phoneQty, warehouse.phoneQty) && Objects.equals(tracking, warehouse.tracking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator, actual_status, send_to, date, id_article, id_supplier, order_number, sku, imei, model, gb, color, grade, supplier, phoneQty, tracking);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "operator='" + operator + '\'' +
                ", actual_status='" + actual_status + '\'' +
                ", send_to='" + send_to + '\'' +
                ", date=" + date +
                ", id_article=" + id_article +
                ", id_supplier=" + id_supplier +
                ", order_number=" + order_number +
                ", sku='" + sku + '\'' +
                ", imei=" + imei +
                ", model='" + model + '\'' +
                ", gb=" + gb +
                ", color='" + color + '\'' +
                ", grade='" + grade + '\'' +
                ", supplier='" + supplier + '\'' +
                ", phoneQty=" + phoneQty +
                ", tracking='" + tracking + '\'' +
                '}';
    }
}
