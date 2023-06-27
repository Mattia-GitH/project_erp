package com.production.erp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "PHASES_TBL")
public class PhasesEntity {

    @Id
    @Column(name = "PHASE")
    public String phase;

    public PhasesEntity() {
    }

    public PhasesEntity(String phase) {
        this.phase = phase;
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
        PhasesEntity that = (PhasesEntity) o;
        return Objects.equals(phase, that.phase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phase);
    }

    @Override
    public String toString() {
        return "PhasesEntity{" +
                "phase='" + phase + '\'' +
                '}';
    }
}
