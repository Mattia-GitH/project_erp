package com.production.erp.repository;

import com.production.erp.entity.PhoneEntity;
import com.production.erp.importExport.ITCExportModel;
import com.production.erp.importExport.OutputExportModel;
import com.production.erp.importExport.ShippingExportModel;
import com.production.erp.view.ITCView;
import com.production.erp.view.PhoneInfo;
import com.production.erp.view.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneEntity, Long> {

    @Query("SELECT new com.production.erp.view.ITCView(p.id_article, p.id_supplier, p.imei, p.model, p.gb, a.grade_sup, s.supplier) FROM PhoneEntity AS p INNER JOIN ArticleEntity AS a ON p.id_article = a.id INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id WHERE p.imei NOT IN (SELECT imei FROM  StatusEntity)")
    List<ITCView> itcView();

    @Query("SELECT new com.production.erp.view.ITCView(p.id_article, p.id_supplier, p.imei, p.model, p.gb, a.grade_sup, s.supplier) FROM PhoneEntity AS p INNER JOIN ArticleEntity AS a ON p.id_article = a.id INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id WHERE p.imei NOT IN (SELECT imei FROM  StatusEntity) AND s.supplier = :supplier")
    List<ITCView> itcViewFilter(@Param("supplier")String supplier);

    @Query("SELECT new com.production.erp.view.ITCView(p.id_article, p.id_supplier, p.imei, p.model, p.gb, a.grade_sup, s.supplier) FROM PhoneEntity AS p INNER JOIN ArticleEntity AS a ON p.id_article = a.id INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id WHERE s.supplier = :supplier")
    List<ITCView> testFilter(@Param("supplier")String supplier);

    @Query("SELECT new com.production.erp.view.ITCView(p.id_article, p.id_supplier, p.imei, p.model, p.gb, a.grade_sup, s.supplier) FROM PhoneEntity AS p INNER JOIN ArticleEntity AS a ON p.id_article = a.id INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id")
    List<ITCView> test();

    @Query("SELECT new java.lang.String(a.grade_sup) FROM PhoneEntity AS p INNER JOIN ArticleEntity AS a ON p.id_article = a.id WHERE p.imei = :imei")
    String getGradeSup(@Param("imei")Long imei);

    Optional<PhoneEntity> findByImei(Long imei);

    // Data for filter
    @Query("SELECT new java.lang.Long(p.order_number) FROM PhoneEntity AS p INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id INNER JOIN ArticleEntity AS a ON p.id_article = a.id GROUP BY p.order_number")
    List<Long> orderNumberData();

    @Query("SELECT new java.lang.String(p.sku) FROM PhoneEntity AS p INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id INNER JOIN ArticleEntity AS a ON p.id_article = a.id GROUP BY p.sku")
    List<String> skuData();

    @Query("SELECT new java.lang.String(p.model) FROM PhoneEntity AS p INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id INNER JOIN ArticleEntity AS a ON p.id_article = a.id GROUP BY p.model")
    List<String> modelData();

    @Query("SELECT new java.lang.String(p.color) FROM PhoneEntity AS p INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id INNER JOIN ArticleEntity AS a ON p.id_article = a.id GROUP BY p.color")
    List<String> colorData();

    @Query("SELECT new java.lang.String(a.grade_sup) FROM PhoneEntity AS p INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id INNER JOIN ArticleEntity AS a ON p.id_article = a.id GROUP BY a.grade_sup")
    List<String> gradeData();

    @Query("SELECT new java.lang.String(s.prod_name) FROM PhoneEntity AS p INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id INNER JOIN ArticleEntity AS a ON p.id_article = a.id GROUP BY s.supplier")
    List<String> supplierData();

    @Query("SELECT new java.lang.Integer(p.gb) FROM PhoneEntity AS p INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id INNER JOIN ArticleEntity AS a ON p.id_article = a.id GROUP BY p.gb")
    List<Integer> gbData();
//    finish data for create filter

    @Query("SELECT new com.production.erp.view.Warehouse(p.id_article, p.id_supplier, p.order_number, p.sku, p.imei, p.model, p.gb, p.color, a.grade_sup, s.prod_name) FROM PhoneEntity AS p INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id INNER JOIN ArticleEntity AS a ON p.id_article = a.id LEFT JOIN LastStatusViewEntity AS v ON p.imei = v.imei WHERE (:order_number IS NULL OR p.order_number = :order_number) AND (:sku IS NULL OR p.sku = :sku) AND (:model IS NULL OR p.model = :model) AND (:color IS NULL OR p.color = :color) AND (:grade IS NULL OR a.grade_sup = :grade) AND (:supplier IS NULL OR s.prod_name = :supplier) AND (:gb = 0 OR p.gb = :gb) AND v.send_to <> 'SENT' AND (:imei IS NULL OR p.imei = :imei)")
    List<Warehouse> warehouseViewFiltered(@Param("order_number")Long order_number, @Param("sku")String sku, @Param("model")String model, @Param("color")String color, @Param("grade")String grade, @Param("supplier")String supplier, @Param("gb")int gb, @Param("imei")Long imei);

    @Query("SELECT new com.production.erp.view.Warehouse(p.id_article, p.sku, p.model, p.gb, p.color, COUNT(p.imei)) FROM PhoneEntity AS p INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id WHERE (:sku IS NULL OR p.sku = :sku) AND (:model IS NULL OR p.model = :model) AND (:color IS NULL OR p.color = :color) AND (:gb = 0 OR p.gb = :gb) GROUP BY p.sku")
    List<Warehouse> warehouseViewSkuFiltered(@Param("sku")String sku, @Param("model")String model, @Param("gb")int gb, @Param("color")String color);

    @Query("SELECT new com.production.erp.view.Warehouse(v.operator, v.actual_status, v.send_to, v.date, p.id_article, p.id_supplier, p.order_number, p.sku, p.imei, p.model, p.gb, p.color, a.grade_sup, s.supplier) FROM  PhoneEntity AS p INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id INNER JOIN  ArticleEntity AS a ON p.id_article = a.id LEFT JOIN LastStatusViewEntity AS v ON p.imei = v.imei WHERE p.sku = :sku AND (:order_number IS NULL OR p.order_number = :order_number) AND (:model IS NULL OR p.model = :model) AND (:gb = 0 OR p.gb = :gb) AND (:grade IS NULL OR a.grade_sup = :grade) AND (:supplier IS NULL OR s.prod_name = :supplier) AND (:actual_status IS NULL OR v.actual_status = :actual_status) AND (:imei IS NULL OR p.imei = :imei)")
    List<Warehouse> warehouseViewFindSKUFiltered(@Param("sku")String sku, @Param("order_number")Long order_number, @Param("model")String model, @Param("gb")int gb, @Param("grade")String grade, @Param("supplier")String supplier, @Param("actual_status") String actual_status, @Param("imei")Long imei);

    @Query("SELECT new com.production.erp.view.PhoneInfo(p.order_number, p.imei,p.model,p.gb,p.color,p.sku,s.prod_name) FROM PhoneEntity as p INNER JOIN SuppliersEntity as s ON p.id_supplier = s.id WHERE p.imei = :imei")
    PhoneInfo phoneInfos(@Param("imei")Long imei);

    @Modifying
    @Query("UPDATE PhoneEntity p SET p.sku = :sku WHERE p.imei = :imei")
    void updateSku(@Param("imei")Long imei, @Param("sku")String sku);

    @Query(" SELECT new com.production.erp.importExport.ITCExportModel(p.imei, s.prod_name, p.order_number, p.model, p.gb, g.grade_sup, p.sku, p.color, g.grade_check) FROM PhoneEntity AS p INNER JOIN SuppliersEntity AS s ON s.id = p.id_supplier INNER JOIN GradeEntity AS g ON p.imei = g.imei INNER JOIN StatusEntity AS sw ON sw.imei = p.imei WHERE sw.actualStatus = 'ITC' AND sw.date BETWEEN :date AND :date2 GROUP BY sw.imei ORDER BY sw.date DESC ")
    List<ITCExportModel> phoneExport(@Param("date") java.util.Date date, @Param("date2") java.util.Date date2);

    @Query("SELECT new com.production.erp.importExport.ShippingExportModel(COUNT(p.imei),p.sku, AVG(s.price)) FROM PhoneEntity AS p INNER JOIN LastStatusViewEntity AS sw ON p.imei = sw.imei INNER JOIN ShippingEntity AS s on s.imei = p.imei WHERE sw.send_to = 'SENT' GROUP BY p.sku")
    List<ShippingExportModel> shippingExport();

    @Query("SELECT new com.production.erp.importExport.OutputExportModel(p.imei, p.color, g.grade_check) FROM PhoneEntity AS p INNER JOIN LastStatusViewEntity AS sw ON p.imei = sw.imei INNER JOIN GradeEntity AS g ON p.imei = g.imei WHERE sw.send_to = 'STOCK' AND sw.date > :date")
    List<OutputExportModel> outputExport(@Param("date")Date date);

    @Query("SELECT new com.production.erp.view.Warehouse(p.sku, p.model, p.gb, p.color, COUNT(p.imei)) FROM PhoneEntity AS p INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id INNER JOIN LastStatusViewEntity AS sw ON p.imei = sw.imei WHERE sw.send_to = 'STOCK' AND (:sku IS NULL OR p.sku = :sku) AND (:model IS NULL OR p.model = :model) AND (:color IS NULL OR p.color = :color) AND (:gb = 0 OR p.gb = :gb) GROUP BY p.sku")
    List<Warehouse> outputHomeView(@Param("sku")String sku, @Param("model")String model, @Param("gb")int gb, @Param("color")String color);

    @Query("SELECT new com.production.erp.view.Warehouse(p.order_number, p.sku, p.imei, p.model, p.gb, p.color, s.prod_name, g.grade_check) FROM PhoneEntity AS p INNER JOIN SuppliersEntity AS s ON p.id_supplier = s.id INNER JOIN GradeEntity AS g ON g.imei = p.imei LEFT JOIN LastStatusViewEntity AS v ON p.imei = v.imei WHERE p.sku = :sku AND (:order_number IS NULL OR p.order_number = :order_number) AND (:supplier IS NULL OR s.prod_name = :supplier) AND v.send_to = 'STOCK' AND (:imei IS NULL OR p.imei = :imei)")
    List<Warehouse> outputSkuView(@Param("sku")String sku, @Param("order_number")Long order_number, @Param("supplier")String supplier, @Param("imei")Long imei);
}