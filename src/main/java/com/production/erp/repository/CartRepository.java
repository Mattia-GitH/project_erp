package com.production.erp.repository;

import com.production.erp.entity.CartEntity;
import com.production.erp.view.CartView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
    @Query("SELECT new com.production.erp.view.CartView(c.id, c.id_supplier, c.id_article, a.model, a.gb, a.grade_sup, c.qty, c.price, c.iva, s.supplier) FROM CartEntity AS c INNER JOIN ArticleEntity AS a ON c.id_article = a.id INNER JOIN SuppliersEntity AS s ON s.id = c.id_supplier")
    List<CartView> cartView();

    @Modifying
    @Query(value = "truncate CART_TBL", nativeQuery = true)
    void truncate();
}