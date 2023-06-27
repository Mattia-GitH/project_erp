package com.production.erp.model;

import java.util.Objects;

public class CartModel {
    private Long id_article;
    private int qty;
    private Long id_supplier;
    private Long id;
    private double price;
    private int iva;

    public CartModel() {
    }

    public CartModel(Long id_article, int qty, Long id_supplier, Long id, double price, int iva) {
        this.id_article = id_article;
        this.qty = qty;
        this.id_supplier = id_supplier;
        this.id = id;
        this.price = price;
        this.iva = iva;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        CartModel cartModel = (CartModel) o;
        return qty == cartModel.qty && Double.compare(cartModel.price, price) == 0 && iva == cartModel.iva && Objects.equals(id_article, cartModel.id_article) && Objects.equals(id_supplier, cartModel.id_supplier) && Objects.equals(id, cartModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_article, qty, id_supplier, id, price, iva);
    }

    @Override
    public String toString() {
        return "CartModel{" +
                "id_article=" + id_article +
                ", qty=" + qty +
                ", id_supplier=" + id_supplier +
                ", id=" + id +
                ", price=" + price +
                ", iva=" + iva +
                '}';
    }
}
