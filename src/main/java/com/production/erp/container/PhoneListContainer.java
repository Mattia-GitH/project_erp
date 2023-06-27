package com.production.erp.container;

import com.production.erp.model.PhoneModel;

import java.util.List;

public class PhoneListContainer {
    private List<PhoneModel> phones;
    private String color;

    public List<PhoneModel> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneModel> phones) {
        this.phones = phones;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
