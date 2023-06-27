package com.production.erp.importExport;

import java.util.Objects;

public class ShippingExportModel {
    private Long qty;
    private String sku;
    private double price;

    public ShippingExportModel() {
    }

    public ShippingExportModel(Long qty, String sku, double price) {
        this.qty = qty;
        this.sku = sku;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
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
        ShippingExportModel that = (ShippingExportModel) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(sku, that.sku) && Objects.equals(qty, that.qty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, qty, price);
    }

    @Override
    public String toString() {
        return "ShippingExportModel{" +
                "sku='" + sku + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
}
