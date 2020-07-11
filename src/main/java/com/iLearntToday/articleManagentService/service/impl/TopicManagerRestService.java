package com.iLearntToday.articleManagentService.service.impl;

import com.iLearntToday.articleManagentService.entity.Topic;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class TopicManagerRestService {
    @Autowired
    RestTemplate restTemplate;

    public boolean saveTopics(List<String> topictags){
        List<Topic> topicList = new ArrayList<>();
        for(String topicName:topictags){
            topicList.add(new Topic(topicName,new Timestamp(System.currentTimeMillis())));
        }
        ResponseEntity<?> response=null;
        try{
                 response=  restTemplate.postForEntity("http://topic-manager-service/topic/save-all",topicList,ResponseEntity.class);
        }
        catch (Exception e){
            System.out.println("Exception occured while connecting topic service ");
        }
        System.out.println(restTemplate.getForObject("http://topic-manager-service/topic/test",String.class));
        return false;
    }



}
