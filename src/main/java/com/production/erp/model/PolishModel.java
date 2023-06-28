package com.production.erp.model;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class PolishModel {
    private Long id;
    private Long imei;
    private Date date;
    private String operator;
    private String result;
    private Time time;

    public PolishModel() {
    }

    public PolishModel(Long id, Long imei, Date date, String operator, String result, Time time) {
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
        PolishModel that = (PolishModel) o;
        return Objects.equals(id, that.id) && Objects.equals(imei, that.imei) && Objects.equals(date, that.date) && Objects.equals(operator, that.operator) && Objects.equals(result, that.result) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imei, date, operator, result, time);
    }

    @Override
    public String toString() {
        return "PolishModel{" +
                "id=" + id +
                ", imei=" + imei +
                ", date=" + date +
                ", operator='" + operator + '\'' +
                ", result='" + result + '\'' +
                ", time=" + time +
                '}';
    }
}
