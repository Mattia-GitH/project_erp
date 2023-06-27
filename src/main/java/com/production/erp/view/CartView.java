package com.production.erp.view;

import java.util.List;
import java.util.Objects;

public class CartView {
    private Long id;
    private Long id_supplier;
    private Long id_article;
    private String model;
    private int gb;
    private String grade_sup;
    private int qty;
    private double price;
    private int iva;
    private String supplier;
    private List<CartView> cartList;

    public CartView() {
    }

    public CartView(List<CartView> cartList) {
        this.cartList = cartList;
    }

    public CartView(Long id, Long id_supplier, Long id_article, String model, int gb, String grade_sup, int qty, double price, int iva, String supplier, List<CartView> cartList) {
        this.id = id;
        this.id_supplier = id_supplier;
        this.id_article = id_article;
        this.model = model;
        this.gb = gb;
        this.grade_sup = grade_sup;
        this.qty = qty;
        this.price = price;
        this.iva = iva;
        this.supplier = supplier;
        this.cartList = cartList;
    }

    public CartView(Long id, Long id_supplier, Long id_article, String model, int gb, String grade_sup, int qty, double price, int iva, String supplier) {
        this.id = id;
        this.id_supplier = id_supplier;
        this.id_article = id_article;
        this.model = model;
        this.gb = gb;
        this.grade_sup = grade_sup;
        this.qty = qty;
        this.price = price;
        this.iva = iva;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Long id_supplier) {
        this.id_supplier = id_supplier;
    }

    public Long getId_article() {
        return id_article;
    }

    public void setId_article(Long id_article) {
        this.id_article = id_article;
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

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public List<CartView> getCartList() {
        return cartList;
    }

    public void setCartList(List<CartView> cartList) {
        this.cartList = cartList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartView cartView = (CartView) o;
        return gb == cartView.gb && qty == cartView.qty && Double.compare(cartView.price, price) == 0 && iva == cartView.iva && Objects.equals(id, cartView.id) && Objects.equals(id_supplier, cartView.id_supplier) && Objects.equals(id_article, cartView.id_article) && Objects.equals(model, cartView.model) && Objects.equals(grade_sup, cartView.grade_sup) && Objects.equals(supplier, cartView.supplier) && Objects.equals(cartList, cartView.cartList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_supplier, id_article, model, gb, grade_sup, qty, price, iva, supplier, cartList);
    }

    @Override
    public String toString() {
        return "CartView{" +
                "id=" + id +
                ", id_supplier=" + id_supplier +
                ", id_article=" + id_article +
                ", model='" + model + '\'' +
                ", gb=" + gb +
                ", grade_sup='" + grade_sup + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", iva=" + iva +
                ", supplier='" + supplier + '\'' +
                ", cartList=" + cartList +
                '}';
    }
}
