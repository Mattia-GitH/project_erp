package com.production.erp.model;

import java.util.Objects;

public class Orders {
    private String model;
    private int gb;
    private String grade_sup;
    private int qty;
    private Long id_article;
    private String supplier;
    private Long number_order;

    public Orders() {
    }

    public Orders(String model, int gb, String grade_sup, int qty, Long id_article, String supplier, Long number_order) {
        this.model = model;
        this.gb = gb;
        this.grade_sup = grade_sup;
        this.qty = qty;
        this.id_article = id_article;
        this.supplier = supplier;
        this.number_order = number_order;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Long getId_article() {
        return id_article;
    }

    public void setId_article(Long id_article) {
        this.id_article = id_article;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Long getNumber_order() {
        return number_order;
    }

    public void setNumber_order(Long number_order) {
        this.number_order = number_order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders that = (Orders) o;
        return gb == that.gb && qty == that.qty && Objects.equals(model, that.model) && Objects.equals(grade_sup, that.grade_sup) && Objects.equals(id_article, that.id_article) && Objects.equals(supplier, that.supplier) && Objects.equals(number_order, that.number_order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, gb, grade_sup, qty, id_article, supplier, number_order);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "model='" + model + '\'' +
                ", gb=" + gb +
                ", grade_sup='" + grade_sup + '\'' +
                ", qty=" + qty +
                ", id_article=" + id_article +
                ", supplier='" + supplier + '\'' +
                ", number_order=" + number_order +
                '}';
    }
}
