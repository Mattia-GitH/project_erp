package com.production.erp.repository;

import com.production.erp.entity.IssueListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IssueListRepository extends JpaRepository<IssueListEntity, Long> {
    Optional<IssueListEntity> findByTl(String tl);
}
