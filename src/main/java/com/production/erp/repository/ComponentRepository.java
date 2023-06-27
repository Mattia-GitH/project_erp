package com.production.erp.repository;

import com.production.erp.entity.ComponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComponentRepository extends JpaRepository<ComponentEntity, Long> {
    Optional<ComponentEntity> findBySku(@Param("sku") String sku);

    List<ComponentEntity> findAll();

    @Modifying
    @Query("UPDATE ComponentEntity SET qty = :qty WHERE sku = :sku")
    void updateQty(@Param("sku") String sku, @Param("qty") int qty);
}
