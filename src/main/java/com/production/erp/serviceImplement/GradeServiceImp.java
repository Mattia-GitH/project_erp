package com.production.erp.serviceImplement;

import com.production.erp.converter.GradeConverter;
import com.production.erp.entity.GradeEntity;
import com.production.erp.exception.GradeNotFoundException;
import com.production.erp.model.GradeModel;
import com.production.erp.repository.GradeRepository;
import com.production.erp.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImp implements GradeService {
    private final GradeRepository repository;
    private final GradeConverter converter;

    @Autowired
    public GradeServiceImp(GradeRepository repository, GradeConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public GradeModel createGrade(GradeModel gradeModel) {
        GradeEntity toSave = repository.save(converter.toEntity(gradeModel));
        return converter.toModel(toSave);
    }

    @Override
    public List<GradeModel> listGrades() {
        List<GradeEntity> entityList = repository.findAll();
        return converter.listToModels(entityList);
    }

    @Override
    public GradeModel gradeById(Long id) {
        Optional<GradeEntity> optional = repository.findById(id);
        if (optional.isPresent()){
            return converter.toModel(optional.get());
        } else {
            throw new GradeNotFoundException("Grade not found: " + id);
        }
    }

    @Override
    public GradeModel updateGrade(GradeModel gradeModel, Long imei) {
        Optional<GradeEntity> optional = repository.findById(imei);
        if (optional.isPresent()){
            GradeEntity update = optional.get();
            update.setImei(gradeModel.getImei());
            update.setGrade_sup(gradeModel.getGrade_sup());
            update.setGrade_check(gradeModel.getGrade_check());
            repository.save(update);
            return converter.toModel(update);
        } else {
            throw new GradeNotFoundException("Grade not found: " + imei);
        }
    }

    @Override
    public String delete(Long imei) {
        Optional<GradeEntity> optional = repository.findById(imei);
        if (optional.isPresent()){
            repository.delete(optional.get());
            return "Grade deleted: " + optional.get();
        } else {
            throw new GradeNotFoundException("Grade not found: " + imei);
        }
    }

    public boolean isPresent(Long imei){
        Optional<GradeEntity> optional = repository.findById(imei);
        return optional.isPresent();
    }

    @Override
    public GradeModel findFirstByImeiOrderByIdDesc(Long imei) {
        Optional<GradeEntity> optional = repository.findFirstByImeiOrderByIdDesc(imei);
        if (optional.isPresent()){
            return converter.toModel(optional.get());
        } else {
            throw new GradeNotFoundException("Grade not found. IMEI: " + imei);
        }
    }
}
