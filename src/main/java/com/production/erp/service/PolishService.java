package com.production.erp.service;

import com.production.erp.model.PolishModel;
import com.production.erp.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PolishService {
    PolishModel createPolish(PolishModel polishModel);

    List<PolishModel> listPolish();

    PolishModel polishByImei(Long imei);

    List<PolishModel> allPolishByImei(Long imei);
}
