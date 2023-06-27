package com.production.erp.service;

import com.production.erp.model.ChestModel;

import java.util.List;

public interface ChestService {
    ChestModel createChest(ChestModel chestModel);

    List<ChestModel> chestsList();

    ChestModel chestById(Long id);

    ChestModel updateChest(ChestModel chestModel, Long id);

    String delete(Long id);

    Long findLastChestNumber();

    void deleteChestNumber(Long number);

    List<ChestModel> findByNumber(Long number);

    ChestModel findFirstByIdOrderByIdDesc(Long id);
}
