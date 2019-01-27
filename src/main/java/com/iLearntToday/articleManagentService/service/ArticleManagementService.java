package com.iLearntToday.articleManagentService.service;

import com.iLearntToday.articleManagentService.entity.ArticleVO;

import java.io.IOException;
import java.util.List;

public interface ArticleManagementService {
    List<ArticleVO> getArticlesByParentId(String parent_id) throws IOException;
}
