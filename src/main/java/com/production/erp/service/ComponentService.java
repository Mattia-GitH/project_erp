package com.production.erp.service;

import com.production.erp.model.ComponentModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComponentService {
    ComponentModel findBySku(String sku);

    List<ComponentModel> componentsList();

    void updateQty(String sku, int qty);
}
