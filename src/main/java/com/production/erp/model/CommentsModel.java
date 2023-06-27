package com.production.erp.model;

import java.util.Date;
import java.util.Objects;

public class CommentsModel {
    private Long id;
    private Long imei;
    private String status;
    private String id_issue;
    private String comment;
    private Date date;
    private String operator;

    public CommentsModel() {
    }

    public CommentsModel(Long id, Long imei, String status, String id_issue, String comment, Date date, String operator) {
        this.id = id;
        this.imei = imei;
        this.status = status;
        this.id_issue = id_issue;
        this.comment = comment;
        this.date = date;
        this.operator = operator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId_issue() {
        return id_issue;
    }

    public void setId_issue(String id_issue) {
        this.id_issue = id_issue;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentsModel that = (CommentsModel) o;
        return Objects.equals(id, that.id) && Objects.equals(imei, that.imei) && Objects.equals(status, that.status) && Objects.equals(id_issue, that.id_issue) && Objects.equals(comment, that.comment) && Objects.equals(date, that.date) && Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imei, status, id_issue, comment, date, operator);
    }

    @Override
    public String toString() {
        return "CommentsModel{" +
                "id=" + id +
                ", imei=" + imei +
                ", status='" + status + '\'' +
                ", id_issue='" + id_issue + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", operator='" + operator + '\'' +
                '}';
    }
}
