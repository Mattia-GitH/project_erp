package com.production.erp.model;


import java.util.Objects;

public class PhasesModel {
    public String phase;

    public PhasesModel() {
    }

    public PhasesModel(String phase) {
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
        PhasesModel that = (PhasesModel) o;
        return Objects.equals(phase, that.phase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phase);
    }

    @Override
    public String toString() {
        return "PhasesModel{" +
                "phase='" + phase + '\'' +
                '}';
    }
}
