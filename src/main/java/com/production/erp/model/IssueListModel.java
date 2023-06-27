package com.production.erp.model;


import com.production.erp.entity.IssueListEntity;

import java.util.Objects;

public class IssueListModel {
    private Long id;
    private String tl;
    private String label;
    private String department;

    public IssueListModel() {
    }

    public IssueListModel(Long id, String tl, String label, String department) {
        this.id = id;
        this.tl = tl;
        this.label = label;
        this.department = department;
    }

    public IssueListModel(IssueListEntity issueListEntity) {
        this.id = issueListEntity.getId();
        this.tl = issueListEntity.getDepartment();
        this.label = issueListEntity.getLabel();
        this.department = issueListEntity.getDepartment();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTl() {
        return tl;
    }

    public void setTl(String tl) {
        this.tl = tl;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssueListModel that = (IssueListModel) o;
        return Objects.equals(id, that.id) && Objects.equals(tl, that.tl) && Objects.equals(label, that.label) && Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tl, label, department);
    }

    @Override
    public String toString() {
        return "IssueListModel{" +
                "id=" + id +
                ", tl='" + tl + '\'' +
                ", label='" + label + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
