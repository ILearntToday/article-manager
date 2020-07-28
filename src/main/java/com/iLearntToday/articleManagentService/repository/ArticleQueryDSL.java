package com.iLearntToday.articleManagentService.repository;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
@Repository
public class ArticleQueryDSL {




    String getArticleByListOfTopics(List<String> topicNameList){
        RestClient esClient = RestClient.builder(new HttpHost("localhost", 9200, "http")).build();
        Request request = new Request("POST", "/articles/_doc/_search");
        request.setJsonEntity("{\n" +
                "  \"query\":{\n" +
                "    \"match_all\":{}\n" +
                "  },\n" +
                "   \"sort\":[\n" +
                "   { \"numberOfLikes\":\"desc\"}\n" +
                "  ]\n" +
                "\n" +
                "}");

        try {
            Response response = esClient.performRequest(request);
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
