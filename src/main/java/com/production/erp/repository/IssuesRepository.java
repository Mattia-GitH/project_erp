package com.production.erp.repository;

import com.production.erp.entity.IssuesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuesRepository extends JpaRepository<IssuesEntity, Long> {
}
