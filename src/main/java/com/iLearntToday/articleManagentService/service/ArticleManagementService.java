package com.iLearntToday.articleManagentService.service;

import com.iLearntToday.articleManagentService.entity.ArticleVO;

import java.io.IOException;
import java.util.List;


public interface ArticleManagementService
{
    List<ArticleVO> getBlogsById( String id ) throws IOException;

}
