package com.iLearntToday.articleManagentService.repository;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ArticleQueryDSL {

    @Autowired
    ElasticsearchTemplate esTemplate;

    String getArticleByListOfTopics(List<String> topicNameList){

    return null;

    }



}
