package com.production.erp.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CART_TBL")
public class CartEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID_ARTICLE")
    private Long id_article;

    @Column(name = "QTY")
    private int qty;

    @Column(name = "ID_SUPPLIER")
    private Long id_supplier;

    @Column(name = "PRICE")
    private double price;

    @Column(name = "IVA")
    private int iva;

    public CartEntity() {
    }

    public CartEntity(Long id, Long id_article, int qty, Long id_supplier, double price, int iva) {
        this.id = id;
        this.id_article = id_article;
        this.qty = qty;
        this.id_supplier = id_supplier;
        this.price = price;
        this.iva = iva;
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

    public Long getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Long id_supplier) {
        this.id_supplier = id_supplier;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntity that = (CartEntity) o;
        return qty == that.qty && Double.compare(that.price, price) == 0 && iva == that.iva && Objects.equals(id, that.id) && Objects.equals(id_article, that.id_article) && Objects.equals(id_supplier, that.id_supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_article, qty, id_supplier, price, iva);
    }

    @Override
    public String toString() {
        return "CartEntity{" +
                "id=" + id +
                ", id_article=" + id_article +
                ", qty=" + qty +
                ", id_supplier=" + id_supplier +
                ", price=" + price +
                ", iva=" + iva +
                '}';
    }
}
