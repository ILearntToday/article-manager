package com.iLearntToday.articleManagentService.controller;

import com.iLearntToday.articleManagentService.entity.Article;
import com.iLearntToday.articleManagentService.entity.ResponseStatus;
import com.iLearntToday.articleManagentService.service.ArticleManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController()
@RequestMapping(value = "api/v1/")
public class ArticleController {
    private static final Logger LOG = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private ArticleManagementService articleManagementService;

    @RequestMapping(value="/saveAll",method = RequestMethod.POST)
    public ResponseEntity<ResponseStatus> saveAllArticle(@RequestBody List<Article> articles){
        return new ResponseEntity<ResponseStatus>(articleManagementService.saveAllArticle(articles),HttpStatus.OK);
    }

    @RequestMapping(value = "/articles/{parent_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getArticlesByParentId(
            @PathVariable("parent_id") String parentId) throws IOException {
        LOG.info("Request submitted to fetch article with parentId {}", parentId);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
