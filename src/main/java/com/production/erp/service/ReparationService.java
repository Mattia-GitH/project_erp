package com.production.erp.service;

import com.production.erp.model.ReparationModel;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ReparationService {
    ReparationModel createReparation(ReparationModel reparationModel);

    List<ReparationModel> reparationsList();

    ReparationModel reparationById(Long id);

    ReparationModel updateArticle(ReparationModel ReparationModel, Long id);

    String delete(Long id);

    List<ReparationModel> findByImeiAndDateAfter(Long imei, Date date);
}
