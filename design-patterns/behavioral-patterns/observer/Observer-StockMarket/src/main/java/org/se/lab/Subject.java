package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class knows its observers and provides an interface for attaching and
 * detaching observer objects.
 * Any number of observer objects may observe a subject. 
 */
public class Subject
{
    private List<Observer> observers = new ArrayList<Observer>();
    
    public List<Observer> getObservers()
    {
        System.out.println("Subject.getObservers()");
        return observers;
    }
    
    public void attachObserver(Observer o)
    {
        System.out.println("Subject.attachObserver()");
        observers.add(o);
    }
    
    public void detachObserver(Observer o)
    {
        System.out.println("Subject.detachObserver()");
        observers.remove(o);
    }
    
    public void notifyObservers()
    {
        System.out.println("Subject.notifyObservers()");
        observers.forEach(Observer::update);
    }
}
