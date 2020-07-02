package com.iLearntToday.articleManagentService.repository;


import com.iLearntToday.articleManagentService.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository  extends ElasticsearchRepository<Article, String> {

}
