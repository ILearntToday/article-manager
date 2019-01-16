package com.iLearntToday.articleManagentService.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleVO {

    private String parent_Id;
    private long timestamp;
    private String blogTitle;
    private String shortDescription;
    private String fullDescription;
    private String userId;
    private int numberOfLikes;

    public ArticleVO(String parent_Id, long timestamp, String blogTitle, String shortDescription, String fullDescription,
                     String userId, int numberOfLikes) {
        this.parent_Id = parent_Id;
        this.timestamp = timestamp;
        this.blogTitle = blogTitle;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.userId = userId;
        this.numberOfLikes = numberOfLikes;
    }

    public ArticleVO() {
    }

    public String getParent_Id() {
        return parent_Id;
    }


    public void setParent_Id(String parent_Id) {
        this.parent_Id = parent_Id;
    }


    public long getTimestamp() {
        return timestamp;
    }


    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    public String getBlogTitle() {
        return blogTitle;
    }


    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }


    public String getShortDescription() {
        return shortDescription;
    }


    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }


    public String getFullDescription() {
        return fullDescription;
    }


    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public int getNumberOfLikes() {
        return numberOfLikes;
    }


    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    @Override
    public String toString() {
        return "ArticleVO{" + "parent_Id='" + parent_Id + '\'' + ", timestamp=" + timestamp + ", blogTitle='" + blogTitle + '\''
                + ", shortDescription='" + shortDescription + '\'' + ", fullDescription='" + fullDescription + '\'' + ", userId='"
                + userId + '\'' + ", numberOfLikes=" + numberOfLikes + '}';
    }
}
