package com.production.erp.view;

import java.util.Objects;

public class ITCView {
    private int id_article;
    private Long id_supplier;
    private Long imei;
    private String model;
    private int gb;
    private String grade_sup;
    private String supplier;

    public ITCView() {
    }

    public ITCView(int id_article, Long id_supplier, Long imei, String model, int gb, String grade_sup, String supplier) {
        this.id_article = id_article;
        this.id_supplier = id_supplier;
        this.imei = imei;
        this.model = model;
        this.gb = gb;
        this.grade_sup = grade_sup;
        this.supplier = supplier;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public Long getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(Long id_supplier) {
        this.id_supplier = id_supplier;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ITCView itcView = (ITCView) o;
        return id_article == itcView.id_article && gb == itcView.gb && Objects.equals(id_supplier, itcView.id_supplier) && Objects.equals(imei, itcView.imei) && Objects.equals(model, itcView.model) && Objects.equals(grade_sup, itcView.grade_sup) && Objects.equals(supplier, itcView.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_article, id_supplier, imei, model, gb, grade_sup, supplier);
    }

    @Override
    public String toString() {
        return "ITCView{" +
                "id_article=" + id_article +
                ", id_supplier=" + id_supplier +
                ", imei=" + imei +
                ", model='" + model + '\'' +
                ", gb=" + gb +
                ", grade_sup='" + grade_sup + '\'' +
                ", supplier='" + supplier + '\'' +
                '}';
    }
}
