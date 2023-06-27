package com.production.erp.service;

import com.production.erp.model.ReportModel;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ReportService {
    ReportModel createReport(ReportModel reportModel);

    List<ReportModel> listReports();

    ReportModel updateReport(ReportModel reportModel, Long id);

    String delete(Long id);

    ReportModel alreadyReported(String issue, String operator, String reporter, Long imei);

    List<ReportModel> loadReports(Date bigDate, Date smallDate, Long imei);
}
