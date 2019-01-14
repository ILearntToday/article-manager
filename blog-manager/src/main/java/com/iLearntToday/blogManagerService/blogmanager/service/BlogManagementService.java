package com.iLearntToday.blogManagerService.blogmanager.service;

import com.iLearntToday.blogManagerService.blogmanager.entity.BlogVO;

import java.io.IOException;
import java.util.List;


public interface BlogManagementService
{
    List<BlogVO> getBlogsById( String id ) throws IOException;
}
