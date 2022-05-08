package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public abstract class Publisher
{
    private List<Subscriber> subscribers = new ArrayList<Subscriber>();
    
    public List<Subscriber> getSubscribers()
    {
        return subscribers;
    }
    
    public void attachSubscriber(Subscriber subscriber)
    {
        if(subscriber == null)
            throw new IllegalArgumentException("Invalid subscriber!");        
        subscribers.add(subscriber);
    }
    
    public void notifySubscribers()
    {
        for(Subscriber s : subscribers)
        {
            s.update(this);
        }
    }
}
