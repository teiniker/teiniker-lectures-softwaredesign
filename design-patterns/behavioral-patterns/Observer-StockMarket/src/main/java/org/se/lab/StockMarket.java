package org.se.lab;

/**
 * This class is a ConcreteSubject that stores state of interest to
 * ConcreteObserver objects and sends a notification to its observers 
 * when its state changes.
 */
public class StockMarket
    extends Subject
{
    public StockMarket(int dax, int dow)
    {
    	System.out.println("StockMarket().StockMarket()");
    	this.dax = dax;
    	this.dow = dow;
    }
    
    
    // Subject's states

    private int dax;
    public int getDax()
    {
    	System.out.println("StockMarket().getDax()");
    	return dax;
    }
    public void setDax(int dax)
    {
    	System.out.println("StockMarket().setDax(" + dax + ")");
    	this.dax = dax;
    	notifyObservers();
    }
    
    
    private int dow;
    public int getDow()
    {
    	System.out.println("StockMarket().getDow()");
    	return dow;
    }
    public void setDow(int dow)
    {
    	System.out.println("StockMarket().setDow(" + dow + ")");
    	this.dow = dow;
    	notifyObservers();
    }
}
