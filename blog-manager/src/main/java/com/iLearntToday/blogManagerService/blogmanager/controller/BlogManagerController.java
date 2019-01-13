package com.iLearntToday.blogManagerService.blogmanager.controller;


import com.iLearntToday.blogManagerService.blogmanager.entity.BlogVO;
import com.iLearntToday.blogManagerService.blogmanager.service.BlogManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController () @RequestMapping (value = "blogdetails/v1") public class BlogManagerController
{
    @Autowired BlogManagementService blogManagementService;


    @RequestMapping (value = "/getall/{id}", method = RequestMethod.GET) public ResponseEntity<?> getAllBlogsOfId()
    {
        blogManagementService.getBlogsById( "-1" );
        return new ResponseEntity<>( new BlogVO(), HttpStatus.OK );
    }

}

