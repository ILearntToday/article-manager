package com.iLearntToday.blogManagerService.blogmanager.entity;

public class BlogVO
{
    String parentId;
    long timestamp;
    String blogTitle;
    String shortDescription;
    String fullDescription;
    String userId;
    String numberOfLikes;


    public BlogVO()
    {
    }


    public BlogVO( String parentId, long timestamp, String blogTitle, String shortDescription, String fullDescription,
        String userId, String numberOfLikes )
    {
        this.parentId = parentId;
        this.timestamp = timestamp;
        this.blogTitle = blogTitle;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.userId = userId;
        this.numberOfLikes = numberOfLikes;
    }


    public String getParentId()
    {
        return parentId;
    }


    public void setParentId( String parentId )
    {
        this.parentId = parentId;
    }


    public long getTimestamp()
    {
        return timestamp;
    }


    public void setTimestamp( long timestamp )
    {
        this.timestamp = timestamp;
    }


    public String getBlogTitle()
    {
        return blogTitle;
    }


    public void setBlogTitle( String blogTitle )
    {
        this.blogTitle = blogTitle;
    }


    public String getShortDescription()
    {
        return shortDescription;
    }


    public void setShortDescription( String shortDescription )
    {
        this.shortDescription = shortDescription;
    }


    public String getFullDescription()
    {
        return fullDescription;
    }


    public void setFullDescription( String fullDescription )
    {
        this.fullDescription = fullDescription;
    }


    public String getUserId()
    {
        return userId;
    }


    public void setUserId( String userId )
    {
        this.userId = userId;
    }


    public String getNumberOfLikes()
    {
        return numberOfLikes;
    }


    public void setNumberOfLikes( String numberOfLikes )
    {
        this.numberOfLikes = numberOfLikes;
    }
}
