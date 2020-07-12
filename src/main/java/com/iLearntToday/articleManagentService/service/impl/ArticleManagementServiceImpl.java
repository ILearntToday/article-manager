package com.iLearntToday.articleManagentService.service.impl;

import com.iLearntToday.articleManagentService.entity.Article;
import com.iLearntToday.articleManagentService.entity.ResponseVO;
import com.iLearntToday.articleManagentService.repository.ArticleRepository;
import com.iLearntToday.articleManagentService.service.ArticleManagementService;
import org.elasticsearch.index.query.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleManagementServiceImpl  implements ArticleManagementService {
    private static final Logger LOG = LoggerFactory.getLogger(ArticleManagementService.class);
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    TopicManagerRestService topicManagerRestService;

    @Override
    public ResponseVO saveAllArticle(List<Article> articles) {
        articleRepository.saveAll(articles);

        return new ResponseVO(200, "Article saved Successfully!");
    }

    @Override
    public List<Article> getArticlesByUserName(String userId) {
        List<Article> result = articleRepository.findByUserId(userId);
        LOG.debug("article fetched ", result);
        return result;
//        return null;
    }

    @Override
    public List<Article> getArticlesByTopicTags(List<String> topics) {

        List<Article> result = new ArrayList<>();
        BoolQueryBuilder qb1 = new BoolQueryBuilder();

        for (String topic : topics) {
            result.addAll(articleRepository.findByTopicsTags(topic));
        }
        return result;
    }

    @Override
    public String saveArticle(Article article) {
        LOG.debug("saving article to ES "+ article);

        articleRepository.save(article);

        if(topicManagerRestService.saveTopics(article.getTopicsTags())){
            return "Article saved successfully with topics ";
        }
        return "could not save data";
    }
}
