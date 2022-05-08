package org.se.lab;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NewsPublisherTest
{
    @Test
    public void testSubscribers()
    {
        // Set up the object structure
        NewsPublisher news = new NewsPublisher();        
        news.attachSubscriber(new EMailSubscriber());
        news.attachSubscriber(new SmsSubscriber());
        
        // Change the ConcreteSubject's state
        // Google News 5.2.2016
        news.setLatestNews("Wikileaks' Assange Subjected to 'Deprivation of Liberty': UN Panel");
        news.setLatestNews("For Mick Jagger, the sex, drugs and rock 'n' roll of HBO's 'Vinyl' is a familiar world");
        news.setLatestNews("Apple will soon let customers trade in busted iPhones toward a new one");

        List<String> logs = Logger.getInstance().getLogLines();
        Assert.assertEquals(6, logs.size());
        
        System.out.println(logs);
    }
}
