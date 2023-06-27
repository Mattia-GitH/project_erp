package com.production.erp.repository;

import com.production.erp.entity.ArticleEntity;
import com.production.erp.model.ArticleModel;
import com.production.erp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    @Query("SELECT new com.production.erp.model.Orders(a.model, a.gb, a.grade_sup, o.qty, o.id_article, s.supplier, o.order_number) FROM OrderEntity AS o INNER JOIN ArticleEntity as a ON o.id_article = a.id INNER JOIN SuppliersEntity AS s ON s.id = o.id_supplier")
    List<Orders> ordersList();

    @Query("select new com.production.erp.entity.ArticleEntity(id, model, gb, grade_sup) from ArticleEntity WHERE model = :model AND gb = :gb AND grade_sup = :grade_sup ORDER BY id DESC")
    Optional<ArticleEntity> findIdArticle(@Param("model") String model, @Param("gb") int gb, @Param("grade_sup") String grade_sup);
}
