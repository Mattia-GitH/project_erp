package com.production.erp.serviceImplement;

import com.production.erp.converter.ArticleConverter;
import com.production.erp.entity.ArticleEntity;
import com.production.erp.exception.ArticleNotFoundException;
import com.production.erp.model.ArticleModel;
import com.production.erp.model.Orders;
import com.production.erp.repository.ArticleRepository;
import com.production.erp.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImp implements ArticleService {
    private final ArticleRepository repository;
    private final ArticleConverter converter;

    @Autowired
    public ArticleServiceImp(ArticleRepository repository, ArticleConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public ArticleModel createArticle(ArticleModel articleModel) {
        ArticleEntity toSave = repository.save(converter.toEntity(articleModel));
        return converter.toModel(toSave);
    }

    @Override
    public List<ArticleModel> articlesList() {
        List<ArticleEntity> articleEntities = repository.findAll();
        return converter.listToModels(articleEntities);
    }

    @Override
    public ArticleModel articleById(Long id) {
        Optional<ArticleEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            return converter.toModel(optional.get());
        } else {
            throw new ArticleNotFoundException("Article not found: " + id);
        }
    }

    @Override
    public ArticleModel updateArticle(ArticleModel articleModel, Long id) {
        Optional<ArticleEntity> optionalUserEntity = repository.findById(id);
        if (optionalUserEntity.isPresent()) {
            ArticleEntity update = optionalUserEntity.get();
            update.setId(articleModel.getId());
            update.setModel(articleModel.getModel());
            update.setGb(articleModel.getGb());
            update.setGrade_sup(articleModel.getGrade_sup());
            repository.save(update);
            return converter.toModel(update);
        } else {
            throw new ArticleNotFoundException("Article not found id: " + articleModel.getId());
        }
    }

    @Override
    public String delete(Long id) {
        Optional<ArticleEntity> articleEntityOptional = repository.findById(id);
        if (articleEntityOptional.isPresent()) {
            repository.delete(articleEntityOptional.get());
            return "Article deleted " + articleEntityOptional.get();
        } else {
            throw new ArticleNotFoundException("Article not found id: " + id);
        }
    }

    @Override
    public List<Orders> ordersList() {
        return repository.ordersList();
    }

    @Override
    public ArticleModel findIdArticle(String model, int gb, String grade_sup) {
        return converter.toModel(repository.findIdArticle(model, gb, grade_sup).orElseThrow(() -> new ArticleNotFoundException("Article not found: " + model + " " + gb + " " + grade_sup)));
    }

    @Override
    public Boolean articleAlreadyExist(String model, int gb, String grade_sup) {
        Optional<ArticleEntity> optional = repository.findIdArticle(model, gb, grade_sup);
        return optional.isPresent();
    }
}
