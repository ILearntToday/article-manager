package com.iLearntToday.articleManagentService.repository;


import com.iLearntToday.articleManagentService.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleRepository  extends ElasticsearchRepository<Article, String> {
    List<Article> findByUserId(String userName);
    List<Article> findByTopicsTags(String topicName);
}

