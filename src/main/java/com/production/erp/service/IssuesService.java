package com.production.erp.service;

import com.production.erp.model.IssuesModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IssuesService {
    IssuesModel createIssue(IssuesModel issuesModel);

    List<IssuesModel> listIssues();

    IssuesModel issuesByImei(Long imei);

    IssuesModel updateIssues(IssuesModel issuesModel, Long imei);

    String delete(Long imei);
}
