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

import java.util.List;

@RestController()
@RequestMapping(value = "api/v1/")
public class ArticleController {
    private static final Logger LOG = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private ArticleManagementService articleManagementService;


    @RequestMapping(value="articles/save",method = RequestMethod.POST)
    public ResponseEntity<ResponseStatus> saveAllArticle(@RequestBody List<Article> articles){
        return new ResponseEntity<ResponseStatus>(articleManagementService.saveAllArticle(articles),HttpStatus.OK);
    }


    @RequestMapping(value ="/articles",method = RequestMethod.GET)
    public ResponseEntity<?> getArticlesByUserId(@RequestParam("userid") String userId){
        LOG.debug("request to fetch article by user id  "+userId);
        return new ResponseEntity<>(articleManagementService.getArticlesByUserName(userId),HttpStatus.OK);

    }
    @RequestMapping(value="/test",method = RequestMethod.GET)
    public String testAPi(){
        return "Hello From Article service";
    }
}
