package com.production.erp.service;

import com.production.erp.model.GradeModel;

import java.util.List;

public interface GradeService {
    GradeModel createGrade(GradeModel gradeModel);

    List<GradeModel> listGrades();

    GradeModel gradeByImei(Long imei);

    GradeModel updateGrade(GradeModel gradeModel, Long imei);

    String delete(Long imei);

    boolean isPresent(Long imei);
}
