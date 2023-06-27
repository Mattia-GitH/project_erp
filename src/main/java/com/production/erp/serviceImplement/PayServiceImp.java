package com.production.erp.serviceImplement;

import com.production.erp.converter.PayConverter;
import com.production.erp.entity.PayEntity;
import com.production.erp.exception.PayNotFoundException;
import com.production.erp.model.PayModel;
import com.production.erp.repository.PayRepository;
import com.production.erp.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayServiceImp implements PayService {
    private final PayRepository repository;
    private final PayConverter converter;

    @Autowired
    public PayServiceImp(PayRepository repository, PayConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public PayModel createPay(PayModel payModel) {
        PayEntity toSave = repository.save(converter.toEntity(payModel));
        return converter.toModel(toSave);
    }

    @Override
    public List<PayModel> listPay() {
        List<PayEntity> list = repository.findAll();
        return converter.listToModels(list);
    }

    @Override
    public PayModel payByNumberOrder(Long numberOrder) {
        Optional<PayEntity> optional = repository.findById(numberOrder);
        if (optional.isPresent()){
            return converter.toModel(optional.get());
        } else {
            throw new PayNotFoundException("Payment with number order: " + numberOrder + " not found");
        }
    }

    @Override
    public PayModel updatePay(PayModel payModel, Long numberOrder) {
        Optional<PayEntity> optional = repository.findById(numberOrder);
        if (optional.isPresent()){
            PayEntity update = new PayEntity();
            update.setNumber_order(payModel.getNumber_order());
            update.setPaid(payModel.isPaid());
            update.setPayment_options(payModel.getPayment_options());
            repository.save(update);
            return converter.toModel(update);
        } else {
            throw new PayNotFoundException("Payment with number order: " + numberOrder + " not found");
        }
    }

    @Override
    public String delete(Long numberOrder) {
        Optional<PayEntity> optional = repository.findById(numberOrder);
        if (optional.isPresent()){
            repository.delete(optional.get());
            return "Deleted: " + optional.get().toString();
        } else {
            throw new PayNotFoundException("Payment with number order: " + numberOrder + " not found");
        }
    }

    @Override
    public PayModel findByNumber_order(Long order_number) {
        return converter.toModel(repository.findByNumber_order(order_number));
    }
}
