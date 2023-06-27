package com.production.erp.serviceImplement;

import com.production.erp.converter.CommentsConverter;
import com.production.erp.entity.CommentsEntity;
import com.production.erp.exception.CommentsNotFoundException;
import com.production.erp.model.CommentsModel;
import com.production.erp.repository.CommentsRepository;
import com.production.erp.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("commentsService")
public class CommentsServiceImp implements CommentsService {
    private final CommentsRepository repository;
    private final CommentsConverter converter;

    @Autowired
    public CommentsServiceImp(CommentsRepository repository, CommentsConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Transactional
    @Override
    public CommentsModel createComment(CommentsModel commentsModel) {
        CommentsEntity toSave = repository.save(converter.toEntity(commentsModel));
        return converter.toModel(toSave);
    }

    @Override
    public List<CommentsModel> listComments() {
        List<CommentsEntity> entityList = repository.findAll();
        return converter.listToModels(entityList);
    }

    @Override
    public CommentsModel commentByImei(Long imei) {
        Optional<CommentsEntity> optional =repository.findById(imei);
        if(optional.isPresent()){
            return converter.toModel(optional.get());
        } else {
            throw new CommentsNotFoundException("Comment not found: " + imei);
        }
    }

    @Override
    public CommentsModel updateComment(CommentsModel commentsModel, Long imei) {
        Optional<CommentsEntity> optional =repository.findById(imei);
        if(optional.isPresent()){
            CommentsEntity update = optional.get();
            update.setId_issue(commentsModel.getId_issue());
            update.setImei(commentsModel.getImei());
            update.setComment(commentsModel.getComment());
            update.setStatus(commentsModel.getStatus());
            update.setDate(commentsModel.getDate());
            update.setOperator(commentsModel.getOperator());
            repository.save(update);
            return converter.toModel(update);
        } else {
            throw new CommentsNotFoundException("Comment not found: " + imei);
        }
    }

    @Override
    public String delete(Long imei) {
        Optional<CommentsEntity> optional =repository.findById(imei);
        if(optional.isPresent()){
            repository.delete(optional.get());
            return "Phone deleted: " + optional.get();
        } else {
            throw new CommentsNotFoundException("Comment not found: " + imei);
        }
    }

    @Override
    public CommentsModel comment(Long imei, String id_issue, Date date) {
        Optional<CommentsEntity> optional = repository.comment(imei, id_issue, date);
        if(optional.isPresent()){
            return converter.toModel(optional.get());
        } else {
            throw new CommentsNotFoundException("Comment not found: " + imei);
        }
    }

    @Override
    public List<CommentsModel> loadComments(Long imei, Date statusDate, Date testDate) {
        return converter.listToModels(repository.loadComments(imei, statusDate, testDate));
    }
}
