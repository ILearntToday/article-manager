package com.iLearntToday.articleManagentService.service;

import com.iLearntToday.articleManagentService.entity.ArticleVO;

import java.util.List;

public interface ElasticSearchOperations {
    List<ArticleVO> getArticlesByParentId(String parentId) throws Exception;
}
