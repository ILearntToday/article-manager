package com.iLearntToday.articleManagentService.service.impl;

import com.iLearntToday.articleManagentService.entity.Article;
import com.iLearntToday.articleManagentService.entity.ResponseStatus;
import com.iLearntToday.articleManagentService.repository.ArticleRepository;
import com.iLearntToday.articleManagentService.service.ArticleManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleManagementServiceImpl implements ArticleManagementService {
    private static final Logger LOG = LoggerFactory.getLogger(ArticleManagementService.class);
    @Autowired
    ArticleRepository articleRepository;
    @Override
    public ResponseStatus saveAllArticle(List<Article > articles){
         articleRepository.saveAll(articles);
         return new ResponseStatus(200,"Article saved Successfully!");
    }

    @Override
    public List<Article> getArticlesByUserName(String userId) {
        List<Article> result =  articleRepository.findByUserId(userId);
        LOG.debug("article fetched ",result);
        return result;
//        return null;
    }





}
