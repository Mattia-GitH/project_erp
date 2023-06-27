package com.production.erp.service;

import com.production.erp.model.CommentsModel;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public interface CommentsService {
    CommentsModel createComment(CommentsModel commentsModel);

    List<CommentsModel> listComments();

    CommentsModel commentByImei(Long imei);

    CommentsModel updateComment(CommentsModel commentsModel, Long imei);

    String delete(Long imei);

    CommentsModel comment(Long imei, String id_issue, Date date);

    List<CommentsModel> loadComments(Long imei,Date statusDate, Date testDate);
}
