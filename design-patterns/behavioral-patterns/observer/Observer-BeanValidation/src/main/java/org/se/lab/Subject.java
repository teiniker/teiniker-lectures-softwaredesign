package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Subject
{
	/*
	 * Association: ---[*]-> observers:Observer
	 */
	private List<Observer> observers = new ArrayList<Observer>();
	public final void addObserver(Observer observer)
	{
		observers.add(observer);
	}
	
	/*
	 * Notification method
	 */
	public final void notifyObservers()
	{
		observers.forEach(observer -> observer.update(this));
	}
}
