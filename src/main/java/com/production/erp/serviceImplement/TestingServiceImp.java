package com.production.erp.serviceImplement;

import com.production.erp.converter.TestingConverter;
import com.production.erp.entity.TestingEntity;
import com.production.erp.exception.TestNotFoundException;
import com.production.erp.model.TestingModel;
import com.production.erp.repository.TestingRepository;
import com.production.erp.service.TestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TestingServiceImp implements TestingService {
    private final TestingRepository repository;
    private final TestingConverter converter;

    @Autowired
    public TestingServiceImp(TestingRepository repository, TestingConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public TestingModel createTest(TestingModel testModel) {
        return converter.toModel(repository.save(converter.toEntity(testModel)));
    }

    @Override
    public List<TestingModel> listTest() {
        return converter.listToModels(repository.findAll());
    }

    @Override
    public TestingModel testByImei(Long imei) {
        return converter.toModel(repository.findByImei(imei).map(TestingEntity::new).orElseThrow(() -> new TestNotFoundException("Test not found: " + imei)));
    }

    @Override
    public TestingModel updateTest(TestingModel testModel, Long imei, Date date) {
        return converter.toModel((repository.findByImeiAndDate(imei, date).map(t -> repository.save(converter.toEntity(testModel))).orElseThrow(() -> new TestNotFoundException("Test not found: " + imei))));
    }

    @Override
    public String delete(Long imei, Date date) {
        return repository.findByImeiAndDate(imei, date).map(test -> repository.deleteByImeiAndDate(imei, date)).orElseThrow(() -> new TestNotFoundException("Test not found: " + imei));
    }

    @Override
    public TestingModel lastTest(Long imei) {
        TestingEntity entity = repository.findFirstByImeiOrderByDateDesc(imei);
        if (entity != null){
            return converter.toModel(entity);
        } else {
            TestingModel model = new TestingModel();
            model.setImei(imei);
            return model;
        }
    }

    @Override
    public TestingModel findFirstByImeiAndDate(Long imei, Date date, Date date2) {
        Optional<TestingEntity> optional = repository.findFirstByImeiAndDateBetweenOrderByDateDesc(imei, date, date2);
        if (optional.isPresent()){
            return converter.toModel(optional.get());
        } else {
            TestingModel model = new TestingModel();
            model.setImei(123456789321456L);
            return model;
        }
    }

    @Override
    public List<BigDecimal> iOS() {
        return repository.iOS();
    }
}
