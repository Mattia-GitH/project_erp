package com.production.erp.model;

import java.util.Objects;

public class SuppliersModel {
    private Long id;
    private String supplier;
    private String address;
    private String mail;
    private String phone;
    private String prod_name;
    private boolean rma;

    public SuppliersModel() {
    }

    public SuppliersModel(String supplier) {
        this.supplier = supplier;
    }

    public SuppliersModel(Long id, String supplier, String address, String mail, String phone, String prod_name, boolean rma) {
        this.id = id;
        this.supplier = supplier;
        this.address = address;
        this.mail = mail;
        this.phone = phone;
        this.prod_name = prod_name;
        this.rma = rma;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public boolean isRma() {
        return rma;
    }

    public void setRma(boolean rma) {
        this.rma = rma;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuppliersModel that = (SuppliersModel) o;
        return rma == that.rma && Objects.equals(id, that.id) && Objects.equals(supplier, that.supplier) && Objects.equals(address, that.address) && Objects.equals(mail, that.mail) && Objects.equals(phone, that.phone) && Objects.equals(prod_name, that.prod_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supplier, address, mail, phone, prod_name, rma);
    }

    @Override
    public String toString() {
        return "SuppliersModel{" +
                "id=" + id +
                ", supplier='" + supplier + '\'' +
                ", address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", prod_name='" + prod_name + '\'' +
                ", rma=" + rma +
                '}';
    }
}
