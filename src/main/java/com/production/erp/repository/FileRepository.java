package com.production.erp.repository;

import com.production.erp.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
    @Query("select new com.production.erp.entity.FileEntity(f.id, f.order_number, f.name, f.type, f.data, f.format) from FileEntity f where f.order_number = :order_number")
    List<FileEntity> findByOrder_number(@Param("order_number")Long order_number);
}
