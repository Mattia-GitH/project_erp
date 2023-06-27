package com.production.erp.repository;

import com.production.erp.entity.IssuesCategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuesCategoriesRepository extends JpaRepository<IssuesCategoriesEntity, String> {
}
