package com.production.erp.repository;

import com.production.erp.entity.CommentsEntity;
import com.production.erp.model.CommentsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentsRepository extends JpaRepository<CommentsEntity, Long> {
    @Query("SELECT c FROM CommentsEntity AS c WHERE c.imei = :imei AND c.id_issue = :id_issue AND c.date < :date")
    Optional<CommentsEntity> comment(@Param("imei")Long imei, @Param("id_issue")String id_issue, @Param("date") Date date);

    @Query("SELECT c FROM CommentsEntity AS c WHERE c.date < :testDate AND c.date > :statusDate AND c.imei = :imei")
    List<CommentsEntity> loadComments(@Param("imei")Long imei, @Param("statusDate")Date statusDate, @Param("testDate")Date testDate);
}