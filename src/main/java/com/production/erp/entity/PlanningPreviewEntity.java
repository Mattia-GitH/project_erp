package com.production.erp.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PLANNING_PREVIEW_TBL")
public class PlanningPreviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "QTY")
    private int qty;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "OPERATOR")
    private String operator;

    public PlanningPreviewEntity() {
    }

    public PlanningPreviewEntity(Long id, Date date, String sku, int qty, String status, String operator) {
        this.id = id;
        this.date = date;
        this.sku = sku;
        this.qty = qty;
        this.status = status;
        this.operator = operator;
    }

    public PlanningPreviewEntity(PlanningPreviewEntity entity) {
        this.id = entity.getId();
        this.date = entity.getDate();
        this.sku = entity.getSku();
        this.qty = entity.getQty();
        this.status = entity.getStatus();
        this.operator = entity.getOperator();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        PlanningPreviewEntity that = (PlanningPreviewEntity) o;
        return qty == that.qty && Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(sku, that.sku) && Objects.equals(status, that.status) && Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, sku, qty, status, operator);
    }

    @Override
    public String toString() {
        return "PlanningPreviewEntity{" +
                "id=" + id +
                ", date=" + date +
                ", sku='" + sku + '\'' +
                ", qty=" + qty +
                ", status='" + status + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
