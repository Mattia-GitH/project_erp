package com.production.erp.service;

import com.production.erp.model.TestingModel;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public interface TestingService {
    TestingModel createTest(TestingModel testModel);

    List<TestingModel> listTest();

    TestingModel testByImei(Long imei);

    TestingModel updateTest(TestingModel testModel, Long imei, Date date);

    String delete(Long imei, Date date);

    TestingModel lastTest(Long imei);

    TestingModel findFirstByImeiAndDate(Long imei, Date date, Date date2);

    List<BigDecimal> iOS();
}
