package com.production.erp.service;

import com.production.erp.model.GradeModel;

import java.util.List;

public interface GradeService {
    GradeModel createGrade(GradeModel gradeModel);

    List<GradeModel> listGrades();

    GradeModel gradeById(Long id);

    GradeModel updateGrade(GradeModel gradeModel, Long imei);

    String delete(Long imei);

    boolean isPresent(Long imei);

    GradeModel findFirstByImeiOrderByIdDesc(Long imei);
}
