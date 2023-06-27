package com.production.erp.model;

import java.util.Objects;

public class IssuesCategoriesModel {
    private String id;
    private String category;
    private String code;
    private String label;

    public IssuesCategoriesModel() {
    }

    public IssuesCategoriesModel(String id, String category, String code, String label) {
        this.id = id;
        this.category = category;
        this.code = code;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuesCategoriesModel that = (IssuesCategoriesModel) o;
        return Objects.equals(id, that.id) && Objects.equals(category, that.category) && Objects.equals(code, that.code) && Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, code, label);
    }

    @Override
    public String toString() {
        return "IssuesCategoriesModel{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", code='" + code + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
