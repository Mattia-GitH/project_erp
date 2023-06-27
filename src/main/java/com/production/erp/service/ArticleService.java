package com.production.erp.service;

import com.production.erp.model.ArticleModel;
import com.production.erp.model.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    ArticleModel createArticle(ArticleModel articleModel);

    List<ArticleModel> articlesList();

    ArticleModel articleById(Long id);

    ArticleModel updateArticle(ArticleModel articleModel, Long id);

    String delete(Long id);

    List<Orders> ordersList();

    ArticleModel findIdArticle(String model, int gb, String grade_sup);

    Boolean articleAlreadyExist(String model, int gb, String grade_sup);
}
