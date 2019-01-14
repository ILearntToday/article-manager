package com.iLearntToday.blogManagerService.blogmanager.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iLearntToday.blogManagerService.blogmanager.entity.BlogVO;
import com.iLearntToday.blogManagerService.blogmanager.service.ElasticSearchOperations;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.pipeline.movavg.models.EwmaModel;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service public class ElasticSearchOperationsImpl implements ElasticSearchOperations
{
    private static final Logger LOG = LoggerFactory.getLogger( ElasticSearchOperationsImpl.class );
    @Autowired RestHighLevelClient restHighLevelClient;
    @Autowired ObjectMapper objectMappper;
    @Value ("${filter.elasticsearch.name}") private String indexNameConst;
    @Value ("${filter.elasticsearch.type}") private String indexType;


    public List<BlogVO> searchBlogById( String blogParentId )
    {
        LOG.info( "Creating query to hit elastic search" );
        List<BlogVO> blogsfetched = new ArrayList<>();
        SearchRequest searchRequest = new SearchRequest( indexNameConst );
        searchRequest.types( indexType );
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        BoolQueryBuilder query = new BoolQueryBuilder();

        BoolQueryBuilder internalBoolQuery = new BoolQueryBuilder();
        internalBoolQuery.should( QueryBuilders.matchQuery( "parent_Id", blogParentId ).operator( Operator.AND ) );
        query.filter( internalBoolQuery );

        searchSourceBuilder.query( query );

        LOG.debug( "{}", query );
        searchRequest.source( searchSourceBuilder );
        LOG.debug( "{}", searchSourceBuilder );
        try {
            SearchResponse searchResponse = restHighLevelClient.search( searchRequest );
            LOG.info( "Query to elastic search done successfully, number of entries fetched {} ",searchResponse.getHits().totalHits );
            blogsfetched = convertSearchResponseToBlogObject( searchResponse );
        } catch ( IOException e ) {

            LOG.info( "Could not connect to elastic search {}",e );
        } catch ( Exception e ) {
            LOG.info( "Some error occured while doing elastic search operations " );
        }
        return blogsfetched;
    }


    List<BlogVO> convertSearchResponseToBlogObject( SearchResponse searchResponse ) throws IOException
    {
        List<BlogVO> blogVOS = null;
        if ( searchResponse.getHits().totalHits > 0 ) {
            blogVOS = Arrays.stream( searchResponse.getHits().getHits() ).map( x -> {
                try {
                    return objectMappper.readValue( x.getSourceAsString(), BlogVO.class );
                } catch ( IOException e ) {
                    LOG.info( "Error while converting Json String to object {}",e );
                    return null;
                }
            } ).collect( Collectors.toList() );
        }
        LOG.debug( "Entries fetched from elastic search {}",blogVOS );
        return blogVOS;


    }


}
