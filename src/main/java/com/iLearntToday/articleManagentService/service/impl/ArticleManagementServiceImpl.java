package com.iLearntToday.articleManagentService.service.impl;

import com.iLearntToday.articleManagentService.entity.ArticleVO;
import com.iLearntToday.articleManagentService.service.ArticleManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleManagementServiceImpl implements ArticleManagementService {
    private static final Logger LOG = LoggerFactory.getLogger(ArticleManagementService.class);
    @Autowired
    private ElasticSearchOperationsImpl elasticSearchOperations;

    @Override
    public List<ArticleVO> getBlogsById(String id) {
        LOG.info("Query to get List of blogs from elastic search");
        return elasticSearchOperations.searchBlogById(id);
    }
}
