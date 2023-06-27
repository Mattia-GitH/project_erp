package com.production.erp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ISSUES_TBL")
public class IssuesEntity {
    @Id
    @Column(name = "IMEI")
    private Long imei;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "OPERATOR")
    private String operator;

    @Column(name = "ID_ISSUE")
    private int id_issue;

    public IssuesEntity() {
    }

    public IssuesEntity(Long imei, Date date, String operator, int id_issue) {
        this.imei = imei;
        this.date = date;
        this.operator = operator;
        this.id_issue = id_issue;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getId_issue() {
        return id_issue;
    }

    public void setId_issue(int id_issue) {
        this.id_issue = id_issue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuesEntity that = (IssuesEntity) o;
        return id_issue == that.id_issue && Objects.equals(imei, that.imei) && Objects.equals(date, that.date) && Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imei, date, operator, id_issue);
    }

    @Override
    public String toString() {
        return "IssuesEntity{" +
                "imei=" + imei +
                ", date=" + date +
                ", operator='" + operator + '\'' +
                ", id_issue=" + id_issue +
                '}';
    }
}
