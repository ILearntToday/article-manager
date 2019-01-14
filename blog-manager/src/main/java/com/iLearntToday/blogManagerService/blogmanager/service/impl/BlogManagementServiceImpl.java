package com.iLearntToday.blogManagerService.blogmanager.service.impl;

import com.iLearntToday.blogManagerService.blogmanager.entity.BlogVO;
import com.iLearntToday.blogManagerService.blogmanager.service.BlogManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service public class BlogManagementServiceImpl implements BlogManagementService
{
    @Autowired ElasticSearchOperationsImpl elasticSearchOperations;


    @Override public List<BlogVO> getBlogsById( String id )
    {

        return elasticSearchOperations.searchBlogById( id );
    }

}
