package com.production.erp.container;

import com.production.erp.model.ChestModel;

import java.util.List;

public class ChestsContainer {
    public List<ChestModel> chestList;
    public String phase;

    public List<ChestModel> getChestList() {
        return chestList;
    }

    public void setChestList(List<ChestModel> chestList) {
        this.chestList = chestList;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }
}
