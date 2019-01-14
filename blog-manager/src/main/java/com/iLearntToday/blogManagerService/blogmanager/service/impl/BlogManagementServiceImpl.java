package com.iLearntToday.blogManagerService.blogmanager.service.impl;

import com.iLearntToday.blogManagerService.blogmanager.controller.BlogManagerController;
import com.iLearntToday.blogManagerService.blogmanager.entity.BlogVO;
import com.iLearntToday.blogManagerService.blogmanager.service.BlogManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service public class BlogManagementServiceImpl implements BlogManagementService
{     private static final Logger LOG = LoggerFactory.getLogger( BlogManagementService.class );
    @Autowired ElasticSearchOperationsImpl elasticSearchOperations;


    @Override public List<BlogVO> getBlogsById( String id )
    {
        LOG.info( "Query to get List of blogs from elastic search" );
        return elasticSearchOperations.searchBlogById( id );
    }

}
