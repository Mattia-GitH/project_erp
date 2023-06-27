package com.production.erp.service;

import com.production.erp.model.PayModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PayService {
    PayModel createPay(PayModel payModel);

    List<PayModel> listPay();

    PayModel payByNumberOrder(Long numberOrder);

    PayModel updatePay(PayModel payModel, Long numberOrder);

    String delete(Long numberOrder);

    PayModel findByNumber_order(Long order_number);
}
