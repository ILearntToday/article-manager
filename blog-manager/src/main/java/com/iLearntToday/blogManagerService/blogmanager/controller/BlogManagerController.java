package com.iLearntToday.blogManagerService.blogmanager.controller;


import com.iLearntToday.blogManagerService.blogmanager.service.BlogManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController () @RequestMapping (value = "blogdetails/v1") public class BlogManagerController
{

    private static final Logger LOG = LoggerFactory.getLogger( BlogManagerController.class );
    @Autowired BlogManagementService blogManagementService;


    @RequestMapping (value = "/getblogs/{parentId}", method = RequestMethod.GET) public ResponseEntity<?> getAllBlogsOfId(
        @PathVariable String parentId ) throws IOException
    {
        LOG.info("Request submitted to query with parentId {}",parentId);
        return new ResponseEntity<>( blogManagementService.getBlogsById( parentId ), HttpStatus.OK );
    }

}