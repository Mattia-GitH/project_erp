package com.production.erp.serviceImplement;

import com.production.erp.converter.ReportConverter;
import com.production.erp.entity.ReportEntity;
import com.production.erp.exception.ReportNotFoundException;
import com.production.erp.model.ReportModel;
import com.production.erp.repository.ReportRepository;
import com.production.erp.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImp implements ReportService {
    private final ReportRepository repository;
    private final ReportConverter converter;

    @Autowired
    public ReportServiceImp(ReportRepository repository, ReportConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public ReportModel createReport(ReportModel reportModel) {
        return converter.toModel(repository.save(converter.toEntity(reportModel)));
    }

    @Override
    public List<ReportModel> listReports() {
        return converter.listToModels(repository.findAll());
    }

    @Override
    public ReportModel updateReport(ReportModel reportModel, Long id) {
        return converter.toModel(repository.findById(id).map(r -> repository.save(converter.toEntity(reportModel))).orElseThrow(() -> new ReportNotFoundException("Report not found" + id)));
    }

    @Override
    public String delete(Long id) {
        Optional<ReportEntity> optional = repository.findById(id);
        if (optional.isPresent()){
            repository.delete(optional.get());
            return "Deleted " + optional.get();
        } else {
            throw new ReportNotFoundException("Report not found" + id);
        }
    }

    @Override
    public ReportModel alreadyReported(String issue, String operator, String reporter, Long imei) {
        if (repository.alreadyReported(issue, operator, reporter, imei) != null){
            return converter.toModel(repository.alreadyReported(issue, operator, reporter, imei));
        }
        return null;
    }

    @Override
    public List<ReportModel> loadReports(Date bigDate, Date smallDate, Long imei) {
        return converter.listToModels(repository.loadReports(bigDate, smallDate, imei));
    }


}
