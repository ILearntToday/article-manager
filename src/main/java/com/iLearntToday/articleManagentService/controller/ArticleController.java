package com.iLearntToday.articleManagentService.controller;

import com.iLearntToday.articleManagentService.entity.Article;
import com.iLearntToday.articleManagentService.entity.QueryModel;
import com.iLearntToday.articleManagentService.entity.ResponseVO;
import com.iLearntToday.articleManagentService.service.ArticleManagementService;
import org.apache.http.HttpHost;
import org.apache.http.util.EntityUtils;
import org.bouncycastle.cert.ocsp.Req;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping(value = "api/v1/articles")
public class ArticleController {
    private static final Logger LOG = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    ElasticsearchTemplate esTemplate;

    @Autowired
    private ArticleManagementService articleManagementService;


    @RequestMapping(value="/save-all",method = RequestMethod.POST)
    public ResponseEntity<?> saveAllArticle(@RequestBody List<Article> articles){

        return new ResponseEntity<>(articleManagementService.saveAllArticle(articles),HttpStatus.OK);
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public ResponseEntity<?> saveAllArticle(@RequestBody Article articles){

        return new ResponseEntity<>(new ResponseVO<String>(HttpStatus.OK.value(),articleManagementService.saveArticle(articles)),HttpStatus.OK);
    }


    @RequestMapping(value ="/",method = RequestMethod.GET)
    public ResponseEntity<?> getArticlesByUserId(@RequestParam("userid") String userId){
        LOG.debug("request to fetch article by user id  "+userId);
        return new ResponseEntity<>(articleManagementService.getArticlesByUserName(userId),HttpStatus.OK);
    }

    @RequestMapping(value="/search-topics", method=RequestMethod.GET)
    public ResponseEntity<?> getByTopics(@RequestParam("listname") String[] topics){

        LOG.debug("request to fetch article by user id  "+topics);
        return new ResponseEntity<>(articleManagementService.getArticlesByTopicTags(topics),HttpStatus.OK);
    }

    @RequestMapping(value="/test",method = RequestMethod.GET)
    public String testAPi(){
        return "Hello From Article service";
    }
}
