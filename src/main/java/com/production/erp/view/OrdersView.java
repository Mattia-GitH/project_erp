package com.production.erp.view;

import java.util.Date;
import java.util.Objects;

public class OrdersView {
    private Long id;
    private Long order_number;
    private Long id_article;
    private Long id_supplier;
    private String model;
    private int gb;
    private String grade;
    private int qty;
    private int init_qty;
    private String supplier;
    private String date;
    private String tracking;

    public OrdersView() {
    }

    public OrdersView(Long id, Long order_number, Long id_article, Long id_supplier, String model, int gb, String grade, int qty, int init_qty, String supplier, String date, String tracking) {
        this.id = id;
        this.order_number = order_number;
        this.id_article = id_article;
        this.id_supplier = id_supplier;
        this.model = model;
        this.gb = gb;
        this.grade = grade;
        this.qty = qty;
        this.init_qty = init_qty;
        this.supplier = supplier;
        this.date = date;
        this.tracking = tracking;
    }

    public OrdersView(Long order_number, String tracking, Long id_article, Long id_supplier, String model, int gb, String grade, int qty, int init_qty, String supplier, String date) {
        this.order_number = order_number;
        this.id_article = id_article;
        this.id_supplier = id_supplier;
        this.model = model;
        this.gb = gb;
        this.grade = grade;
        this.qty = qty;
        this.init_qty = init_qty;
        this.supplier = supplier;
        this.date = date;
        this.tracking = tracking;
    }

    public Long getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Long order_number) {
        this.order_number = order_number;
    }

    public Long getId_article() {
        return id_article;
    }

    public void setId_article(Long id_article) {
        this.id_article = id_article;
    }

    public Long getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Long id_supplier) {
        this.id_supplier = id_supplier;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getInit_qty() {
        return init_qty;
    }

    public void setInit_qty(int init_qty) {
        this.init_qty = init_qty;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersView that = (OrdersView) o;
        return gb == that.gb && qty == that.qty && init_qty == that.init_qty && Objects.equals(id, that.id) && Objects.equals(order_number, that.order_number) && Objects.equals(id_article, that.id_article) && Objects.equals(id_supplier, that.id_supplier) && Objects.equals(model, that.model) && Objects.equals(grade, that.grade) && Objects.equals(supplier, that.supplier) && Objects.equals(date, that.date) && Objects.equals(tracking, that.tracking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order_number, id_article, id_supplier, model, gb, grade, qty, init_qty, supplier, date, tracking);
    }

    @Override
    public String toString() {
        return "OrdersView{" +
                "id=" + id +
                ", order_number=" + order_number +
                ", id_article=" + id_article +
                ", id_supplier=" + id_supplier +
                ", model='" + model + '\'' +
                ", gb=" + gb +
                ", grade='" + grade + '\'' +
                ", qty=" + qty +
                ", init_qty=" + init_qty +
                ", supplier='" + supplier + '\'' +
                ", date='" + date + '\'' +
                ", tracking='" + tracking + '\'' +
                '}';
    }
}
