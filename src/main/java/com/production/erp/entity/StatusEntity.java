package com.production.erp.entity;


import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "STATUS_TBL")
public class StatusEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IMEI")
    private Long imei;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "ACTUAL_STATUS")
    private String actualStatus;

    @Column(name = "SEND_TO")
    private String send_to;

    @Column(name = "OPERATOR")
    private String operator;

    @Column(name = "TIMER")
    private LocalTime timer;

    public StatusEntity() {
    }

    public StatusEntity(Long imei, Date date, String actualStatus, String send_to, String operator) {
        this.imei = imei;
        this.date = date;
        this.actualStatus = actualStatus;
        this.send_to = send_to;
        this.operator = operator;
    }

    public StatusEntity(Long id, Long imei, Date date, String actualStatus, String send_to, String operator, LocalTime timer) {
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

    public void setActualStatus(String actual_status) {
        this.actualStatus = actual_status;
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
        StatusEntity that = (StatusEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(imei, that.imei) && Objects.equals(date, that.date) && Objects.equals(actualStatus, that.actualStatus) && Objects.equals(send_to, that.send_to) && Objects.equals(operator, that.operator) && Objects.equals(timer, that.timer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imei, date, actualStatus, send_to, operator, timer);
    }

    @Override
    public String toString() {
        return "StatusEntity{" +
                "id=" + id +
                ", imei=" + imei +
                ", date=" + date +
                ", actual_status='" + actualStatus + '\'' +
                ", send_to='" + send_to + '\'' +
                ", operator='" + operator + '\'' +
                ", timer=" + timer +
                '}';
    }
}
