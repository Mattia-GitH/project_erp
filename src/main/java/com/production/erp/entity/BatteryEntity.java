package com.production.erp.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "BATTERY_TBL")
public class BatteryEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IMEI")
    private Long imei;

    @Column(name = "SOH")
    private int soh;

    @Column(name = "CYCLES")
    private int cycles;

    @Column(name = "`REPLACE`")
    private boolean replace;

    @Column(name = "DATE")
    private Date date;

    public BatteryEntity() {
    }

    public BatteryEntity(Long imei, int soh, int cycles, boolean replace, Date date) {
        this.imei = imei;
        this.soh = soh;
        this.cycles = cycles;
        this.replace = replace;
        this.date = date;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public int getSoh() {
        return soh;
    }

    public void setSoh(int soh) {
        this.soh = soh;
    }

    public int getCycles() {
        return cycles;
    }

    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    public boolean isReplace() {
        return replace;
    }

    public void setReplace(boolean replace) {
        this.replace = replace;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BatteryEntity that = (BatteryEntity) o;
        return soh == that.soh && cycles == that.cycles && replace == that.replace && Objects.equals(id, that.id) && Objects.equals(imei, that.imei) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imei, soh, cycles, replace, date);
    }

    @Override
    public String toString() {
        return "BatteryEntity{" +
                "id=" + id +
                ", imei=" + imei +
                ", soh=" + soh +
                ", cycles=" + cycles +
                ", replace=" + replace +
                ", date=" + date +
                '}';
    }
}
