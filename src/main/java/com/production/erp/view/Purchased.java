package com.production.erp.view;

import java.util.Date;
import java.util.Objects;

public class Purchased {
    private Long order_number;
    private Date date_purchase;
    private String supplier;
    private Long qty;
    private Long init_qty;
    private double price;
    private String courier;
    private String tracking;
    private String date;
    private boolean paid;

    public Purchased() {
    }

    public Purchased(Long order_number, Date date_purchase, String supplier, Long qty, Long init_qty, double price) {
        this.order_number = order_number;
        this.date_purchase = date_purchase;
        this.supplier = supplier;
        this.qty = qty;
        this.init_qty = init_qty;
        this.price = price;
    }

    public Purchased(Long order_number, Date date_purchase, String supplier) {
        this.order_number = order_number;
        this.date_purchase = date_purchase;
        this.supplier = supplier;
    }

    public Purchased(Long order_number, String supplier, String date) {
        this.order_number = order_number;
        this.supplier = supplier;
        this.date = date;
    }

    public Purchased(Long order_number, Date date_purchase, String supplier, Long qty, Long init_qty, double price, String courier, String tracking, boolean paid) {
        this.order_number = order_number;
        this.date_purchase = date_purchase;
        this.supplier = supplier;
        this.qty = qty;
        this.init_qty = init_qty;
        this.price = price;
        this.courier = courier;
        this.tracking = tracking;
        this.date = date;
        this.paid = paid;
    }

    public Long getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Long order_number) {
        this.order_number = order_number;
    }

    public Date getDate_purchase() {
        return date_purchase;
    }

    public void setDate_purchase(Date date_purchase) {
        this.date_purchase = date_purchase;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public Long getInit_qty() {
        return init_qty;
    }

    public void setInit_qty(Long init_qty) {
        this.init_qty = init_qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchased purchased = (Purchased) o;
        return Double.compare(purchased.price, price) == 0 && paid == purchased.paid && Objects.equals(order_number, purchased.order_number) && Objects.equals(date_purchase, purchased.date_purchase) && Objects.equals(supplier, purchased.supplier) && Objects.equals(qty, purchased.qty) && Objects.equals(init_qty, purchased.init_qty) && Objects.equals(date, purchased.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_number, date_purchase, supplier, qty, init_qty, price, date, paid);
    }

    @Override
    public String toString() {
        return "Purchased{" +
                "order_number=" + order_number +
                ", date_purchase=" + date_purchase +
                ", supplier='" + supplier + '\'' +
                ", qty=" + qty +
                ", init_qty=" + init_qty +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", paid=" + paid +
                '}';
    }
}
