package com.iLearntToday.blogManagerService.blogmanager.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iLearntToday.blogManagerService.blogmanager.entity.BlogVO;
import com.iLearntToday.blogManagerService.blogmanager.service.ElasticSearchOperations;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
 public class ElasticSearchOperationsImpl implements ElasticSearchOperations
{
    private static final Logger LOG = LoggerFactory.getLogger( ElasticSearchOperationsImpl.class );
    @Autowired RestHighLevelClient restHighLevelClient;
    @Autowired RestClient lowLevelRestClient;
    @Autowired ObjectMapper objectMappper;
    @Value ("${filter.elasticsearch.name}") private String indexNameConst;
    @Value ("${filter.elasticsearch.type}") private String indexType;


    public List<BlogVO> searchBlogById( String blogParentId )
    {

        String indexName = indexNameConst + "*";
        LOG.info( "Finding document in elastic search" );
        QueryBuilder matchQueryBuilder = QueryBuilders.matchQuery( "parent_Id", blogParentId );
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query( boolQueryBuilder );
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices( indexName );
        searchRequest.types( indexType );
        searchRequest.source( searchSourceBuilder );
        try {
            SearchResponse searchResponse = restHighLevelClient.search( searchRequest );
        } catch ( IOException e ) {
           // throw new IOException( "Elastic Search IO Exception Occurred" );
        }
        catch ( Exception  e){
            System.out.println(e);
        }
        return null;
    }

}
