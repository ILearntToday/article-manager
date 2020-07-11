package com.iLearntToday.articleManagentService.service.impl;

import com.iLearntToday.articleManagentService.controller.ArticleController;
import com.iLearntToday.articleManagentService.entity.ResponseVO;
import com.iLearntToday.articleManagentService.entity.Topic;
import io.swagger.models.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOG = LoggerFactory.getLogger(TopicManagerRestService.class);
    public boolean saveTopics(List<String> topictags) {
        List<Topic> topicList = new ArrayList<>();
        for (String topicName : topictags) {
            topicList.add(new Topic(topicName, new Timestamp(System.currentTimeMillis())));
        }
        ResponseEntity<ResponseVO> response = null;
        try {
            response = restTemplate.postForEntity("http://topic-manager-service/topic/save-all", topicList, ResponseVO.class);
            if(response.getStatusCode().value()==200){
                LOG.debug("Topic successfully saved to data base");
            }
            else{
                LOG.debug("could not save topic to db" ,response.getBody());
            }
            return true;
        } catch (Exception e) {

            System.out.println("Exception occured while connecting topic service "+e);
        }
        return false;
    }


}
