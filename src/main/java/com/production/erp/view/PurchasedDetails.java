package com.production.erp.view;

import java.util.Date;
import java.util.Objects;

public class PurchasedDetails {
    private Long order_number;
    private Date date_purchase;
    private String model;
    private int gb;
    private String grade_sup;
    private String supplier;
    private int qty;
    private int init_qty;
    private double price;
    private int iva;
    private String sup_order_number;

    public PurchasedDetails() {
    }

    public PurchasedDetails(Long order_number, Date date_purchase, String model, int gb, String grade_sup, String supplier, int qty, int init_qty, double price, int iva) {
        this.order_number = order_number;
        this.date_purchase = date_purchase;
        this.model = model;
        this.gb = gb;
        this.grade_sup = grade_sup;
        this.supplier = supplier;
        this.qty = qty;
        this.init_qty = init_qty;
        this.price = price;
        this.iva = iva;
    }

    public PurchasedDetails(Long order_number, Date date_purchase, String model, int gb, String grade_sup, String supplier, int qty, int init_qty, double price, int iva, String sup_order_number) {
        this.order_number = order_number;
        this.date_purchase = date_purchase;
        this.model = model;
        this.gb = gb;
        this.grade_sup = grade_sup;
        this.supplier = supplier;
        this.qty = qty;
        this.init_qty = init_qty;
        this.price = price;
        this.iva = iva;
        this.sup_order_number = sup_order_number;
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

    public String getGrade_sup() {
        return grade_sup;
    }

    public void setGrade_sup(String grade_sup) {
        this.grade_sup = grade_sup;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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
        PurchasedDetails that = (PurchasedDetails) o;
        return gb == that.gb && qty == that.qty && init_qty == that.init_qty && Double.compare(that.price, price) == 0 && iva == that.iva && Objects.equals(order_number, that.order_number) && Objects.equals(date_purchase, that.date_purchase) && Objects.equals(model, that.model) && Objects.equals(grade_sup, that.grade_sup) && Objects.equals(supplier, that.supplier) && Objects.equals(sup_order_number, that.sup_order_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_number, date_purchase, model, gb, grade_sup, supplier, qty, init_qty, price, iva, sup_order_number);
    }

    @Override
    public String toString() {
        return "PurchasedDetails{" +
                "order_number=" + order_number +
                ", date_purchase=" + date_purchase +
                ", model='" + model + '\'' +
                ", gb=" + gb +
                ", grade_sup='" + grade_sup + '\'' +
                ", supplier='" + supplier + '\'' +
                ", qty=" + qty +
                ", init_qty=" + init_qty +
                ", price=" + price +
                ", iva=" + iva +
                ", sup_order_number='" + sup_order_number + '\'' +
                '}';
    }
}
