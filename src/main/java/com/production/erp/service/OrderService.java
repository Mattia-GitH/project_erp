package com.production.erp.service;

import com.production.erp.model.OrderModel;
import com.production.erp.view.OrdersView;
import com.production.erp.view.Purchased;
import com.production.erp.view.PurchasedDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface OrderService {
    OrderModel createOrder (OrderModel orderModel);

    List<OrderModel> listOrders();

    OrderModel orderById(Long id);

    OrderModel updateOrder (OrderModel orderModel, Long id);

    String delete (long id);

    void updateQty(Integer qty, Long id_article, Long id_supplier,String date, Long number_order, Long id);

    List<Purchased> purchased();

    List<PurchasedDetails> purchasedDetails(Long number_order);

    Long findLastOrderNumber();

    List<Purchased> dataFilter();

    List<Purchased> filter(Long order_number, Date date, String supplier );

    List<OrdersView> ordersView(Long order_number, String model, int gb, String grade, String supplier, String tracking);

    void updateCourier(Long order_number, String courier);

    void updateTracking(Long order_number, String tracking);

    List<String> trackingNumbers();

    void updateDate(Long order_number, String date);

    Boolean orderAlreadyExist(Long id_article, Long id_supplier, Long order_number);

    OrderModel findId(Long id_article, Long id_supplier, String date, Long order_number);

    void updateSupOrderNumber(Long order_number, String sup_order_number);

    void updatePrice(Long order_number, Long id_article, double price);

    Integer checkRev (Long imei);
}
