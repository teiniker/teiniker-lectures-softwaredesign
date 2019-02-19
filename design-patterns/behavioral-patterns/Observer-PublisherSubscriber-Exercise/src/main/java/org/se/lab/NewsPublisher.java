package org.se.lab;

public class NewsPublisher
    extends Publisher
{
    private String latestNews;
    public String getLatestNews()
    {
        return latestNews;
    }
    public void setLatestNews(String latestNews)
    {
        this.latestNews = latestNews;
        notifySubscribers();
    }
}
