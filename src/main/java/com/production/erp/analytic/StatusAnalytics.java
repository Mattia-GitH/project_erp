package com.production.erp.analytic;

import java.util.Date;
import java.util.Objects;

public class StatusAnalytics {
    private Long id;
    private Long imei;
    private Date date;
    private String actualStatus;
    private String send_to;
    private String operator;
    private Date timer;

    public StatusAnalytics() {
    }

    public StatusAnalytics(Long id, Long imei, Date date, String actualStatus, String send_to, String operator, Date timer) {
        this.id = id;
        this.imei = imei;
        this.date = date;
        this.actualStatus = actualStatus;
        this.send_to = send_to;
        this.operator = operator;
        this.timer = timer;
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

    public String getActualStatus() {
        return actualStatus;
    }

    public void setActualStatus(String actualStatus) {
        this.actualStatus = actualStatus;
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

    public Date getTimer() {
        return timer;
    }

    public void setTimer(Date timer) {
        this.timer = timer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusAnalytics that = (StatusAnalytics) o;
        return Objects.equals(id, that.id) && Objects.equals(imei, that.imei) && Objects.equals(date, that.date) && Objects.equals(actualStatus, that.actualStatus) && Objects.equals(send_to, that.send_to) && Objects.equals(operator, that.operator) && Objects.equals(timer, that.timer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imei, date, actualStatus, send_to, operator, timer);
    }

    @Override
    public String toString() {
        return "StatusAnalytics{" +
                "id=" + id +
                ", imei=" + imei +
                ", date=" + date +
                ", actualStatus='" + actualStatus + '\'' +
                ", send_to='" + send_to + '\'' +
                ", operator='" + operator + '\'' +
                ", timer=" + timer +
                '}';
    }
}
