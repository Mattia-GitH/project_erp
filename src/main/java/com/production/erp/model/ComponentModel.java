package com.production.erp.model;

import java.util.Objects;

public class ComponentModel {
    private Long id;
    private int qty;
    private String sku;

    public ComponentModel() {
    }

    public ComponentModel(Long id, int qty, String sku) {
        this.id = id;
        this.qty = qty;
        this.sku = sku;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComponentModel that = (ComponentModel) o;
        return qty == that.qty && Objects.equals(id, that.id) && Objects.equals(sku, that.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, qty, sku);
    }

    @Override
    public String toString() {
        return "ComponentModel{" +
                "id=" + id +
                ", qty=" + qty +
                ", sku='" + sku + '\'' +
                '}';
    }
}
