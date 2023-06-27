package com.production.erp.repository;

import com.production.erp.entity.SuppliersEntity;
import com.production.erp.model.SuppliersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SuppliersRepository extends JpaRepository<SuppliersEntity, Long> {
    @Query("SELECT new com.production.erp.entity.SuppliersEntity(supplier) FROM SuppliersEntity GROUP BY supplier")
    List<SuppliersEntity> supplierList();

    @Query("SELECT new com.production.erp.entity.SuppliersEntity(s.id, s.supplier, s.address, s.mail, s.phone, s.prod_name, s.rma) FROM CartEntity AS c INNER JOIN SuppliersEntity AS s ON c.id_supplier = s.id")
    List<SuppliersEntity> supplierIdInCart();

    @Query(value = "SELECT s.PROD_NAME FROM suppliers_tbl as s INNER JOIN order_tbl AS o ON s.ID = o.ID_SUPPLIER WHERE o.NUMBER_ORDER = :order_number LIMIT 1", nativeQuery = true)
    String supplierFromOrderNumber(@Param("order_number")Long order_number);
}
