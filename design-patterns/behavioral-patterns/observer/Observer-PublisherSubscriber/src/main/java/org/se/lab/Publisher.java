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
        subscribers.add(subscriber);
    }
    
    public void notifySubscribers()
    {
        subscribers.forEach(subscriber -> subscriber.update(this));
    }
}
