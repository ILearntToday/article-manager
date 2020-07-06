package com.iLearntToday.articleManagentService.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName="articles",shards=2)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article  {
    @Id
    String id;
    private String parent_Id;
    private long timestamp;
    private String title;
    private String shortDescription;
    private String fullDescription;
    private String userId;
    private int numberOfLikes;
    List<String> topicsTags;


}
