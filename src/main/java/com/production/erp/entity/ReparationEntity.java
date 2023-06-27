package com.production.erp.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "REPARATIONS_TBL")
public class ReparationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "IMEI")
    private Long imei;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "OPERATOR")
    private String operator;

    @Column(name = "TL")
    private String tl;

    @Column(name = "COMPONENT")
    private String component;

    public ReparationEntity() {
    }

    public ReparationEntity(Long id, Long imei, Date date, String operator, String tl, String component) {
        this.id = id;
        this.imei = imei;
        this.date = date;
        this.operator = operator;
        this.tl = tl;
        this.component = component;
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

    public String getTl() {
        return tl;
    }

    public void setTl(String tl) {
        this.tl = tl;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReparationEntity that = (ReparationEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(imei, that.imei) && Objects.equals(date, that.date) && Objects.equals(operator, that.operator) && Objects.equals(tl, that.tl) && Objects.equals(component, that.component);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imei, date, operator, tl, component);
    }

    @Override
    public String toString() {
        return "ReparationEntity{" +
                "id=" + id +
                ", imei=" + imei +
                ", date=" + date +
                ", operator='" + operator + '\'' +
                ", tl='" + tl + '\'' +
                ", component='" + component + '\'' +
                '}';
    }
}
