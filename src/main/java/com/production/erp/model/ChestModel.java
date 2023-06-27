package com.production.erp.model;

import java.util.Objects;

public class ChestModel {
    private Long id;
    private Long number;
    private Long imei;
    private String phase;

    public ChestModel() {
    }

    public ChestModel(Long id, Long number, Long imei, String phase) {
        this.id = id;
        this.number = number;
        this.imei = imei;
        this.phase = phase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChestModel model = (ChestModel) o;
        return Objects.equals(id, model.id) && Objects.equals(number, model.number) && Objects.equals(imei, model.imei) && Objects.equals(phase, model.phase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, imei, phase);
    }

    @Override
    public String toString() {
        return "ChestModel{" +
                "id=" + id +
                ", number=" + number +
                ", imei=" + imei +
                ", phase='" + phase + '\'' +
                '}';
    }
}
