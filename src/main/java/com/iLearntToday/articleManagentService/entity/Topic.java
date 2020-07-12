package com.iLearntToday.articleManagentService.entity;

import lombok.Data;


import java.sql.Timestamp;


public class Topic {
    String topicName;
    String topicDescription;
    Timestamp creationDate;

    public Topic() {
    }

    public Topic(String topicName, String topicDescription, Timestamp creationDate) {

        this.topicName = topicName;
        this.topicDescription = topicDescription;
        this.creationDate = creationDate;
    }

    public Topic(String topicName, Timestamp creationDate) {
        this.topicName = topicName;
        this.creationDate = creationDate;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
}
