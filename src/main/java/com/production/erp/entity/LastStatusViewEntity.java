package com.production.erp.entity;

import org.hibernate.annotations.Subselect;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "LAST_STATUS_VIEW")
@Immutable
@Subselect("SELECT " +
        "s.ID AS ID, " +
        "s.OPERATOR AS OPERATOR, " +
        "s.ACTUAL_STATUS AS ACTUAL_STATUS, " +
        "s.SEND_TO AS SEND_TO, " +
        "s.DATE AS DATE, " +
        "s.IMEI AS IMEI, " +
        "s.TIMER AS TIMER " +
        "FROM status_tbl AS s " +
        "WHERE s.DATE in (select max(s2.DATE) from status_tbl AS s2 where s.IMEI = s2.IMEI) " +
        "AND s.DATE > '2023-06-01 00:00:00' " +
        "GROUP BY s.IMEI ORDER BY s.DATE DESC")
public class LastStatusViewEntity {
    @Column(name = "OPERATOR")
    private String operator;

    @Column(name = "ACTUAL_STATUS")
    private String actual_status;

    @Column(name = "SEND_TO")
    private String send_to;

    @Column(name = "DATE")
    private Date date;

    @Id
    @Column(name = "IMEI")
    private Long imei;

    public LastStatusViewEntity() {
    }

    public LastStatusViewEntity(String operator, String actual_status, String send_to, Date date, Long imei) {
        this.operator = operator;
        this.actual_status = actual_status;
        this.send_to = send_to;
        this.date = date;
        this.imei = imei;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getActual_status() {
        return actual_status;
    }

    public void setActual_status(String actual_status) {
        this.actual_status = actual_status;
    }

    public String getSend_to() {
        return send_to;
    }

    public void setSend_to(String send_to) {
        this.send_to = send_to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LastStatusViewEntity that = (LastStatusViewEntity) o;
        return Objects.equals(operator, that.operator) && Objects.equals(actual_status, that.actual_status) && Objects.equals(send_to, that.send_to) && Objects.equals(date, that.date) && Objects.equals(imei, that.imei);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator, actual_status, send_to, date, imei);
    }

    @Override
    public String toString() {
        return "LastStatusViewEntity{" +
                "operator='" + operator + '\'' +
                ", actual_status='" + actual_status + '\'' +
                ", send_to='" + send_to + '\'' +
                ", date=" + date +
                ", imei=" + imei +
                '}';
    }
}
