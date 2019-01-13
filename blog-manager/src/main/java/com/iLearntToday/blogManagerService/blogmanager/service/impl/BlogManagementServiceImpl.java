package com.iLearntToday.blogManagerService.blogmanager.service.impl;

import com.iLearntToday.blogManagerService.blogmanager.entity.BlogVO;
import com.iLearntToday.blogManagerService.blogmanager.service.BlogManagementService;
import com.iLearntToday.blogManagerService.blogmanager.service.ElasticSearchOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogManagementServiceImpl implements BlogManagementService
{
    @Autowired ElasticSearchOperationsImpl elasticSearchOperations;

    @Override
    public List<BlogVO> getBlogsById( String id )
    {
        try {
            elasticSearchOperations.searchBlogById( id );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

}
