package com.production.erp.repository;

import com.production.erp.entity.OrderEntity;
import com.production.erp.view.OrdersView;
import com.production.erp.view.Purchased;
import com.production.erp.view.PurchasedDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Modifying
    @Query("UPDATE OrderEntity SET qty = qty - :qty WHERE id = :id AND id_article = :id_article AND id_supplier = :id_supplier AND date = :date AND order_number = :number_order")
    void updateQty(@Param("qty") Integer qty, @Param("id_article") Long id_article, @Param("id_supplier") Long id_supplier, @Param("date")String date, @Param("number_order")Long number_order, @Param("id")Long id);

    @Query("SELECT new com.production.erp.view.Purchased(o.order_number, o.date_purchase, s.supplier,  SUM(o.qty), SUM(o.init_qty), SUM(o.init_qty * o.price * o.iva / 100 + o.init_qty * o.price)) FROM OrderEntity AS o INNER JOIN SuppliersEntity AS s ON s.id = o.id_supplier GROUP BY o.order_number")
    List<Purchased> purchased();

    @Query("SELECT new com.production.erp.view.PurchasedDetails(o.order_number, o.date_purchase, a.model, a.gb, a.grade_sup, s.supplier, o.qty, o.init_qty, o.price, o.iva, o.sup_order_number) FROM OrderEntity AS o INNER JOIN ArticleEntity AS a ON o.id_article = a.id INNER JOIN SuppliersEntity AS s ON o.id_supplier = s.id WHERE o.order_number = :number_order")
    List<PurchasedDetails> purchasedDetails(@Param("number_order")Long number_order);

    @Query("SELECT NEW java.lang.Long(o.order_number) FROM OrderEntity AS o ORDER BY o.order_number DESC ")
    List<Long> findLastOrderNumber();

    @Query("SELECT new com.production.erp.view.Purchased(o.order_number, o.date_purchase, s.supplier) FROM OrderEntity AS o INNER JOIN SuppliersEntity AS s ON s.id = o.id_supplier GROUP BY o.order_number")
    List<Purchased> dataFilter();

    @Query("SELECT new com.production.erp.view.Purchased(o.order_number, o.date_purchase, s.supplier,  SUM(o.qty), SUM(o.init_qty), SUM(o.init_qty * o.price * o.iva / 100 + o.init_qty * o.price), o.courier, o.tracking,p.paid) FROM OrderEntity AS o INNER JOIN SuppliersEntity AS s ON s.id = o.id_supplier INNER JOIN PayEntity AS p ON p.number_order = o.order_number WHERE (:order_number IS NULL OR o.order_number = :order_number) AND (:date IS NULL OR o.date_purchase = :date) AND (:supplier IS NULL OR s.supplier = :supplier) GROUP BY o.order_number")
    List<Purchased> filter(@Param("order_number")Long order_number, @Param("date")Date date, @Param("supplier")String supplier );

    @Query("SELECT new com.production.erp.view.OrdersView(o.id, o.order_number, o.id_article, o.id_supplier, a.model, a.gb, a.grade_sup, o.qty, o.init_qty, s.prod_name, o.date, o.tracking)  FROM OrderEntity AS o INNER JOIN ArticleEntity AS a ON a.id = o.id_article INNER JOIN SuppliersEntity AS s ON s.id = o.id_supplier WHERE (:order_number IS NULL OR o.order_number = :order_number) AND (:model IS NULL OR a.model = :model) AND (:gb = 0 OR a.gb = :gb) AND (:grade IS NULL OR a.grade_sup = :grade) AND (:supplier IS NULL OR s.supplier = :supplier) AND (:tracking IS NULL OR o.tracking = :tracking) ORDER BY o.date DESC ")
    List<OrdersView> ordersView(@Param("order_number")Long order_number, @Param("model")String model, @Param("gb")int gb, @Param("grade")String grade, @Param("supplier")String supplier, @Param("tracking")String tracking);

    @Modifying
    @Query("UPDATE OrderEntity SET courier = :courier WHERE order_number = :order_number")
    void updateCourier(@Param("order_number")Long order_number, @Param("courier")String courier);

    @Modifying
    @Query("UPDATE OrderEntity SET tracking = :tracking WHERE order_number = :order_number")
    void updateTracking(@Param("order_number")Long order_number, @Param("tracking")String tracking);

    @Query(value = "SELECT o.tracking FROM ORDER_TBL AS o GROUP BY o.tracking", nativeQuery = true)
    List<String> trackingNumbers();

    @Modifying
    @Query("UPDATE OrderEntity SET date = :date WHERE order_number = :order_number")
    void updateDate(@Param("order_number")Long order_number, @Param("date")String date);

    @Query("SELECT o FROM OrderEntity AS o WHERE o.id_article = :id_article AND o.id_supplier = :id_supplier AND o.order_number = :order_number")
    Optional<OrderEntity> orderAlreadyExist(@Param("id_article") Long id_article, @Param("id_supplier") Long id_supplier, @Param("order_number") Long order_number);

    @Query("SELECT o FROM OrderEntity AS o WHERE o.id_article = :id_article AND o.id_supplier = :id_supplier AND o.date = :date AND o.order_number = :order_number")
    Optional<OrderEntity> findId(@Param("id_article") Long id_article, @Param("id_supplier") Long id_supplier, @Param("date") String date, @Param("order_number") Long order_number);

    @Modifying
    @Query("UPDATE OrderEntity SET sup_order_number = :sup_order_number WHERE order_number = :order_number")
    void updateSupOrderNumber(@Param("order_number")Long order_number, @Param("sup_order_number")String sup_order_number);

    @Modifying
    @Query("UPDATE OrderEntity SET price = :price WHERE order_number = :order_number AND id_article = :id_article")
    void updatePrice(@Param("order_number")Long order_number, @Param("id_article") Long id_article, @Param("price") double price);

    @Query("SELECT o.iva FROM OrderEntity AS o INNER JOIN PhoneEntity AS p ON o.order_number = p.order_number WHERE p.imei = :imei")
    List<Integer> checkRev (@Param("imei") Long imei);
}