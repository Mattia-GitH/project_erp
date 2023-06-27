package com.production.erp.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PLANNING_TBL")
public class PlanningEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "QTY")
    private Long qty;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "OPERATOR")
    private String operator;

    public PlanningEntity() {
    }

    public PlanningEntity(Long id, Date date, String sku, Long qty, String status, String operator) {
        this.id = id;
        this.date = date;
        this.sku = sku;
        this.qty = qty;
        this.status = status;
        this.operator = operator;
    }

    public PlanningEntity(Long id, Date date, String sku, Long qty, String status) {
        this.id = id;
        this.date = date;
        this.sku = sku;
        this.qty = qty;
        this.status = status;
    }

    public PlanningEntity(PlanningEntity entity) {
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

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
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
        PlanningEntity that = (PlanningEntity) o;
        return qty == that.qty && Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(sku, that.sku) && Objects.equals(status, that.status) && Objects.equals(operator, that.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, sku, qty, status, operator);
    }

    @Override
    public String toString() {
        return "PlanningEntity{" +
                "id=" + id +
                ", date=" + date +
                ", sku='" + sku + '\'' +
                ", qty=" + qty +
                ", status='" + status + '\'' +
                ", operator='" + operator + '\'' +
                '}';
    }
}
