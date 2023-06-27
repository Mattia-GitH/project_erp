package com.production.erp.repository;

import com.production.erp.entity.ChestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChestRepository extends JpaRepository<ChestEntity, Long> {

    @Query("select c from ChestEntity c order by c.id DESC")
    List<ChestEntity> findAllByOrderByIdDesc();

    @Query(value = "SELECT NUMBER FROM chests_tbl ORDER BY NUMBER DESC LIMIT 1", nativeQuery = true)
    Long findLastChestNumber();

    @Modifying
    @Query("DELETE FROM ChestEntity WHERE number = :number")
    void deleteChestNumber(@Param("number")Long number);

    List<ChestEntity> findByNumber(@Param("number")Long number);

    ChestEntity findFirstByIdOrderByIdDesc(@Param("id") Long id);
}
