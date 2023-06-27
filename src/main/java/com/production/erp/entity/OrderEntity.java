package com.production.erp.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ORDER_TBL")
public class OrderEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_ARTICLE")
    private Long id_article;

    @Column(name = "QTY")
    private int qty;

    @Column(name = "INIT_QTY")
    private int init_qty;

    @Column(name = "ID_SUPPLIER")
    private Long id_supplier;

    @Column(name = "DATE")
    private String date;

    @Column(name = "DATE_PURCHASE")
    private Date date_purchase;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "IVA")
    private int iva;

    @Column(name = "NUMBER_ORDER")
    private Long order_number;

    @Column(name = "COURIER")
    private String courier;

    @Column(name = "TRACKING")
    private String tracking;

    @Column(name = "SUP_ORDER_NUMBER")
    private String sup_order_number;

    public OrderEntity() {
    }

    public OrderEntity(Long id, Long id_article, int qty, int init_qty, Long id_supplier, String date, Date date_purchase, double price, int iva, Long order_number, String courier, String tracking, String sup_order_number) {
        this.id = id;
        this.id_article = id_article;
        this.qty = qty;
        this.init_qty = init_qty;
        this.id_supplier = id_supplier;
        this.date = date;
        this.date_purchase = date_purchase;
        this.price = price;
        this.iva = iva;
        this.order_number = order_number;
        this.courier = courier;
        this.tracking = tracking;
        this.sup_order_number = sup_order_number;
    }

    public OrderEntity(Long id, Long id_article, int qty, int init_qty, Long id_supplier, String date, Date date_purchase, double price, int iva, Long order_number, String courier, String tracking) {
        this.id = id;
        this.id_article = id_article;
        this.qty = qty;
        this.init_qty = init_qty;
        this.id_supplier = id_supplier;
        this.date = date;
        this.date_purchase = date_purchase;
        this.price = price;
        this.iva = iva;
        this.order_number = order_number;
        this.courier = courier;
        this.tracking = tracking;
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

    public Long getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Long order_number) {
        this.order_number = order_number;
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
        OrderEntity that = (OrderEntity) o;
        return qty == that.qty && init_qty == that.init_qty && Double.compare(that.price, price) == 0 && iva == that.iva && Objects.equals(id, that.id) && Objects.equals(id_article, that.id_article) && Objects.equals(id_supplier, that.id_supplier) && Objects.equals(date, that.date) && Objects.equals(date_purchase, that.date_purchase) && Objects.equals(order_number, that.order_number) && Objects.equals(courier, that.courier) && Objects.equals(tracking, that.tracking) && Objects.equals(sup_order_number, that.sup_order_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_article, qty, init_qty, id_supplier, date, date_purchase, price, iva, order_number, courier, tracking, sup_order_number);
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", id_article=" + id_article +
                ", qty=" + qty +
                ", init_qty=" + init_qty +
                ", id_supplier=" + id_supplier +
                ", date='" + date + '\'' +
                ", date_purchase=" + date_purchase +
                ", price=" + price +
                ", iva=" + iva +
                ", order_number=" + order_number +
                ", courier='" + courier + '\'' +
                ", tracking='" + tracking + '\'' +
                ", sup_order_number='" + sup_order_number + '\'' +
                '}';
    }
}
