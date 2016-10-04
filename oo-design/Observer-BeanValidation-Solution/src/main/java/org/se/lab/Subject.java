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
		if(observer == null)
			throw new NullPointerException();
		observers.add(observer);
	}
	
	/*
	 * Notification method
	 */
	public final void notifyObservers()
	{
		for(Observer o : observers)
		{
			o.update(this); // push model
		}
	}
}
