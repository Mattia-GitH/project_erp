package com.production.erp.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "POLISH_TBL")
public class PolishEntity {
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

    @Column(name = "RESULT")
    private String result;

    @Column(name = "TIME")
    private Time time;

    public PolishEntity() {
    }

    public PolishEntity(Long id, Long imei, Date date, String operator, String result, Time time) {
        this.id = id;
        this.imei = imei;
        this.date = date;
        this.operator = operator;
        this.result = result;
        this.time = time;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PolishEntity that = (PolishEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(imei, that.imei) && Objects.equals(date, that.date) && Objects.equals(operator, that.operator) && Objects.equals(result, that.result) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imei, date, operator, result, time);
    }

    @Override
    public String toString() {
        return "PolishEntity{" +
                "id=" + id +
                ", imei=" + imei +
                ", date=" + date +
                ", operator='" + operator + '\'' +
                ", result='" + result + '\'' +
                ", time=" + time +
                '}';
    }
}
