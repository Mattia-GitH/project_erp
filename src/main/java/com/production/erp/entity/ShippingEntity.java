package com.production.erp.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "SHIPPING_TBL")
public class ShippingEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ORDER_NUMBER")
    private Long order_number;

    @Column(name = "TRACKING")
    private String tracking;

    @Column(name = "COURIER")
    private String courier;

    @Column(name = "IMEI")
    private Long imei;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "MARKET")
    private String market;

    @Column(name = "OPERATOR")
    private String operator;

    @Column(name = "PRICE")
    private double price;

    public ShippingEntity() {
    }

    public ShippingEntity(Long id, Long order_number, String tracking, String courier, Long imei, Date date, String market, String operator, double price) {
        this.id = id;
        this.order_number = order_number;
        this.tracking = tracking;
        this.courier = courier;
        this.imei = imei;
        this.date = date;
        this.market = market;
        this.operator = operator;
        this.price = price;
    }

    public ShippingEntity(ShippingEntity entity) {
        this.id = entity.getId();
        this.order_number = entity.getOrder_number();
        this.tracking = entity.getTracking();
        this.courier = entity.getCourier();
        this.imei = entity.getImei();
        this.date = entity.getDate();
        this.market = entity.getMarket();
        this.operator = entity.getOperator();
        this.price = entity.getPrice();
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
        ShippingEntity that = (ShippingEntity) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(id, that.id) && Objects.equals(order_number, that.order_number) && Objects.equals(tracking, that.tracking) && Objects.equals(courier, that.courier) && Objects.equals(imei, that.imei) && Objects.equals(date, that.date) && Objects.equals(market, that.market) && Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order_number, tracking, courier, imei, date, market, operator, price);
    }

    @Override
    public String toString() {
        return "ShippingEntity{" +
                "id=" + id +
                ", order_number=" + order_number +
                ", tracking='" + tracking + '\'' +
                ", courier='" + courier + '\'' +
                ", imei=" + imei +
                ", date=" + date +
                ", market='" + market + '\'' +
                ", operator='" + operator + '\'' +
                ", price=" + price +
                '}';
    }
}
