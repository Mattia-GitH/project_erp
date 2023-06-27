package com.production.erp.service;

import com.production.erp.model.IssuesCategoriesModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IssuesCategoriesService {
    IssuesCategoriesModel createIssuesCategory(IssuesCategoriesModel issuesCategoriesModel);

    List<IssuesCategoriesModel> listIssuesCategories();

    IssuesCategoriesModel issuesCategoryById(String id);

    IssuesCategoriesModel updateIssuesCategory(IssuesCategoriesModel issuesCategoriesModel, String id);

    String delete(String id);
}
