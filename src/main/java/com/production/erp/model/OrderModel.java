package com.production.erp.model;

import java.util.Date;
import java.util.Objects;

public class OrderModel {
    private Long id;
    private Long id_article;
    private int qty;
    private int init_qty;
    private Long id_supplier;
    private String date;
    private Date date_purchase;
    private double price;
    private int iva;
    private Long number_order;
    private String courier;
    private String tracking;
    private String sup_order_number;

    public OrderModel() {
    }

    public OrderModel(Long id, Long id_article, int qty, int init_qty, Long id_supplier, String date, Date date_purchase, double price, int iva, Long number_order, String courier, String tracking) {
        this.id = id;
        this.id_article = id_article;
        this.qty = qty;
        this.init_qty = init_qty;
        this.id_supplier = id_supplier;
        this.date = date;
        this.date_purchase = date_purchase;
        this.price = price;
        this.iva = iva;
        this.number_order = number_order;
        this.courier = courier;
        this.tracking = tracking;
    }

    public OrderModel(Long id, Long id_article, int qty, int init_qty, Long id_supplier, String date, Date date_purchase, double price, int iva, Long number_order, String courier, String tracking, String sup_order_number) {
        this.id = id;
        this.id_article = id_article;
        this.qty = qty;
        this.init_qty = init_qty;
        this.id_supplier = id_supplier;
        this.date = date;
        this.date_purchase = date_purchase;
        this.price = price;
        this.iva = iva;
        this.number_order = number_order;
        this.courier = courier;
        this.tracking = tracking;
        this.sup_order_number = sup_order_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_article() {
        return id_article;
    }

    public void setId_article(Long id_article) {
        this.id_article = id_article;
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

    public Long getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Long id_supplier) {
        this.id_supplier = id_supplier;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getDate_purchase() {
        return date_purchase;
    }

    public void setDate_purchase(Date date_purchase) {
        this.date_purchase = date_purchase;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public Long getNumber_order() {
        return number_order;
    }

    public void setNumber_order(Long number_order) {
        this.number_order = number_order;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public String getSup_order_number() {
        return sup_order_number;
    }

    public void setSup_order_number(String sup_order_number) {
        this.sup_order_number = sup_order_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderModel that = (OrderModel) o;
        return qty == that.qty && init_qty == that.init_qty && Double.compare(that.price, price) == 0 && iva == that.iva && Objects.equals(id, that.id) && Objects.equals(id_article, that.id_article) && Objects.equals(id_supplier, that.id_supplier) && Objects.equals(date, that.date) && Objects.equals(date_purchase, that.date_purchase) && Objects.equals(number_order, that.number_order) && Objects.equals(courier, that.courier) && Objects.equals(tracking, that.tracking) && Objects.equals(sup_order_number, that.sup_order_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_article, qty, init_qty, id_supplier, date, date_purchase, price, iva, number_order, courier, tracking, sup_order_number);
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "id=" + id +
                ", id_article=" + id_article +
                ", qty=" + qty +
                ", init_qty=" + init_qty +
                ", id_supplier=" + id_supplier +
                ", date='" + date + '\'' +
                ", date_purchase=" + date_purchase +
                ", price=" + price +
                ", iva=" + iva +
                ", number_order=" + number_order +
                ", courier='" + courier + '\'' +
                ", tracking='" + tracking + '\'' +
                ", sup_order_number='" + sup_order_number + '\'' +
                '}';
    }
}
