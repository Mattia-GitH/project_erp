package com.production.erp.serviceImplement;

import com.production.erp.converter.OrderConverter;
import com.production.erp.entity.OrderEntity;
import com.production.erp.exception.OrderNotFoundException;
import com.production.erp.model.OrderModel;
import com.production.erp.repository.OrderRepository;
import com.production.erp.service.OrderService;
import com.production.erp.view.OrdersView;
import com.production.erp.view.Purchased;
import com.production.erp.view.PurchasedDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {
    private final OrderRepository repository;
    private final OrderConverter converter;

    @Autowired
    public OrderServiceImp(OrderRepository repository, OrderConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public OrderModel createOrder(OrderModel orderModel) {
        Date date = new Date();
        orderModel.setDate_purchase(date);
        OrderEntity toSave = repository.save(converter.toEntity(orderModel));
        return converter.toModel(toSave);
    }

    @Override
    public List<OrderModel> listOrders() {
        List<OrderEntity> orderEntities = repository.findAll();
        return converter.listToModels(orderEntities);
    }

    @Override
    public OrderModel orderById(Long id) {
        Optional<OrderEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            return converter.toModel(optional.get());
        } else {
            throw new OrderNotFoundException("Order not found: " + id);
        }
    }

    @Override
    public OrderModel updateOrder(OrderModel orderModel, Long id) {
        Optional<OrderEntity> orderEntity = repository.findById(id);
        if (orderEntity.isPresent()) {
            OrderEntity update = orderEntity.get();
            update.setId(orderModel.getId());
            update.setId_article(orderModel.getId_article());
            update.setId_supplier(orderModel.getId_supplier());
            update.setQty(orderModel.getQty());
            update.setPrice(orderModel.getPrice());
            update.setIva(orderModel.getIva());
            update.setOrder_number(orderModel.getNumber_order());
            repository.save(update);
            return converter.toModel(update);
        } else {
            throw new OrderNotFoundException("Order not found id: " + orderModel.getId());
        }
    }

    @Override
    public String delete(long id) {
        Optional<OrderEntity> orderEntity = repository.findById(id);
        if (orderEntity.isPresent()) {
            repository.delete(orderEntity.get());
            return "Order deleted " + orderEntity.get();
        } else {
            throw new OrderNotFoundException("Order not found id: " + id);
        }
    }

    @Transactional
    @Override
    public void updateQty(Integer qty, Long id_article, Long id_supplier, String date, Long number_order, Long id) {
        repository.updateQty(qty, id_article, id_supplier, date, number_order, id);
    }

    @Override
    public List<Purchased> purchased() {
        return repository.purchased();
    }

    @Override
    public List<PurchasedDetails> purchasedDetails(Long number_order) {
        return repository.purchasedDetails(number_order);
    }

    @Override
    public Long findLastOrderNumber() {
        List<Long> orderNumber = repository.findLastOrderNumber();
        if (orderNumber.isEmpty()) {
            return 0L;
        } else {
            return orderNumber.get(0);
        }
    }

    @Override
    public List<Purchased> dataFilter() {
        return repository.dataFilter();
    }

    @Override
    public List<Purchased> filter(Long order_number, Date date, String supplier) {
        return repository.filter(order_number, date, supplier);
    }

    @Override
    public List<OrdersView> ordersView(Long order_number, String model, int gb, String grade, String supplier, String tracking) {
        return repository.ordersView(order_number, model, gb, grade, supplier, tracking);
    }

    @Transactional
    @Override
    public void updateCourier(Long order_number, String courier) {
        repository.updateCourier(order_number, courier);
    }

    @Transactional
    @Override
    public void updateTracking(Long order_number, String tracking) {
        repository.updateTracking(order_number, tracking);
    }

    @Override
    public List<String> trackingNumbers() {
        return repository.trackingNumbers();
    }

    @Transactional
    @Override
    public void updateDate(Long order_number, String date) {
        repository.updateDate(order_number, date);
    }

    @Override
    public Boolean orderAlreadyExist(Long id_article, Long id_supplier, Long order_number) {
        Optional<OrderEntity> optional = repository.orderAlreadyExist(id_article, id_supplier, order_number);
        return optional.isPresent();
    }

    @Override
    public OrderModel findId(Long id_article, Long id_supplier, String date, Long order_number) {
        Optional<OrderEntity> optional = repository.findId(id_article, id_supplier, date, order_number);
        if (optional.isPresent()){
            return converter.toModel(optional.get());
        }
        else {
            throw new OrderNotFoundException("order id not found");
        }
    }

    @Transactional
    @Override
    public void updateSupOrderNumber(Long order_number, String sup_order_number) {
        repository.updateSupOrderNumber(order_number, sup_order_number);
    }

    @Transactional
    @Override
    public void updatePrice(Long order_number, Long id_article, double price) {
        repository.updatePrice(order_number, id_article, price);
    }

    @Override
    public Integer checkRev(Long imei) {
        return repository.checkRev(imei).get(0);
    }
}
