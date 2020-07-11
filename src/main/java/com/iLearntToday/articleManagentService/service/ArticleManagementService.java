package com.iLearntToday.articleManagentService.service;

import com.iLearntToday.articleManagentService.entity.Article;
import com.iLearntToday.articleManagentService.entity.ResponseStatus;

import java.util.List;

public interface ArticleManagementService {
    public ResponseStatus saveAllArticle(List<Article> articles);

    public List<Article> getArticlesByUserName(String userName);

    public List<Article> getArticlesByTopicTags(List<String > topics);

    public String saveArticle(Article articles);
}
