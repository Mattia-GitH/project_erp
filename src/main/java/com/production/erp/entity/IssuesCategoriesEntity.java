package com.production.erp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ISSUES_CATEGORY_TBL")
public class IssuesCategoriesEntity {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "CODE")
    private String code;

    @Column(name = "LABEL")
    private String label;

    public IssuesCategoriesEntity() {
    }

    public IssuesCategoriesEntity(String id, String category, String code, String label) {
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
        IssuesCategoriesEntity entity = (IssuesCategoriesEntity) o;
        return Objects.equals(id, entity.id) && Objects.equals(category, entity.category) && Objects.equals(code, entity.code) && Objects.equals(label, entity.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, code, label);
    }

    @Override
    public String toString() {
        return "IssuesCategoriesEntity{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", code='" + code + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
