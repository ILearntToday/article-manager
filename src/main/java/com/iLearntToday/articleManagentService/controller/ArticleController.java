package com.iLearntToday.articleManagentService.controller;


import com.iLearntToday.articleManagentService.service.ArticleManagementService;
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


@RestController () @RequestMapping (value = "api/v1/") public class ArticleController
{

    private static final Logger LOG = LoggerFactory.getLogger( ArticleController.class );
    @Autowired private ArticleManagementService articleManagementService;


    @RequestMapping (value = "/articles/{parent_id}", method = RequestMethod.GET) public ResponseEntity<?> getAllBlogsOfId(
        @PathVariable("parent_id") String parentId ) throws IOException
    {
        LOG.info("Request submitted to fetch article with parentId {}",parentId);
        return new ResponseEntity<>( articleManagementService.getBlogsById( parentId ), HttpStatus.OK );
    }



}