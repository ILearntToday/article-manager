package com.iLearntToday.blogManagerService.blogmanager.service;

import com.iLearntToday.blogManagerService.blogmanager.entity.BlogVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BlogManagementService
{
    List<BlogVO> getBlogsById( String id );
}
