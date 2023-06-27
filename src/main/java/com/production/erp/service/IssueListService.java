package com.production.erp.service;

import com.production.erp.model.IssueListModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IssueListService {
    IssueListModel createIssue(IssueListModel issuesModel);

    List<IssueListModel> listIssues();

    IssueListModel issuesById(Long id);

    IssueListModel updateIssues(IssueListModel issuesModel, Long id);

    String delete(Long id);

    boolean findByTl(String tl);
}
