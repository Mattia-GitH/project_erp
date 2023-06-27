package com.production.erp.model;

import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class StatusModel {
    private Long id;
    private Long imei;
    private Date date;
    private String actual_status;
    private String send_to;
    private String operator;
    private LocalTime timer;

    public StatusModel() {
    }

    public StatusModel(Long id, Long imei, Date date, String actual_status, String send_to, String operator, LocalTime timer) {
        this.id = id;
        this.imei = imei;
        this.date = date;
        this.actual_status = actual_status;
        this.send_to = send_to;
        this.operator = operator;
        this.timer = timer;
    }

    public StatusModel(Long imei, Date date, String actual_status, String send_to, String operator, LocalTime timer) {
        this.imei = imei;
        this.date = date;
        this.actual_status = actual_status;
        this.send_to = send_to;
        this.operator = operator;
        this.timer = timer;
    }

    public StatusModel(Long imei, Date date, String actual_status, String operator) {
        this.imei = imei;
        this.date = date;
        this.actual_status = actual_status;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public LocalTime getTimer() {
        return timer;
    }

    public void setTimer(LocalTime timer) {
        this.timer = timer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusModel that = (StatusModel) o;
        return Objects.equals(id, that.id) && Objects.equals(imei, that.imei) && Objects.equals(date, that.date) && Objects.equals(actual_status, that.actual_status) && Objects.equals(send_to, that.send_to) && Objects.equals(operator, that.operator) && Objects.equals(timer, that.timer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imei, date, actual_status, send_to, operator, timer);
    }

    @Override
    public String toString() {
        return "StatusModel{" +
                "id=" + id +
                ", imei=" + imei +
                ", date=" + date +
                ", actual_status='" + actual_status + '\'' +
                ", send_to='" + send_to + '\'' +
                ", operator='" + operator + '\'' +
                ", timer=" + timer +
                '}';
    }
}
