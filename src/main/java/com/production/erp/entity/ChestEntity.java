package com.production.erp.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CHESTS_TBL")
public class ChestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Long number;

    @Column
    private Long imei;

    @Column
    private String phase;

    public ChestEntity() {
    }

    public ChestEntity(Long id, Long number, Long imei, String phase) {
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
        ChestEntity entity = (ChestEntity) o;
        return Objects.equals(id, entity.id) && Objects.equals(number, entity.number) && Objects.equals(imei, entity.imei) && Objects.equals(phase, entity.phase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, number, imei, phase);
    }

    @Override
    public String toString() {
        return "ChestEntity{" +
                "id=" + id +
                ", number=" + number +
                ", imei=" + imei +
                ", phase='" + phase + '\'' +
                '}';
    }
}
