package com.iLearntToday.blogManagerService.blogmanager.service;


import com.iLearntToday.blogManagerService.blogmanager.entity.BlogVO;

import java.util.List;


public interface ElasticSearchOperations
{
    List<BlogVO> searchBlogById( String parentId ) throws Exception;
}
