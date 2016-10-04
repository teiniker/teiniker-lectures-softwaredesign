package org.se.lab;

/**
 * This ConcreteObserver class maintains a reference to a ConcreteSubject
 * (StockMarket) object and stores state that should stay consistent with the 
 * subject's state.
 * 
 * DowObserver also implements the Observer updating interface to keep its
 * state consistent with the subject's state.
 */
public class DowObserver
    implements Observer
{
    private StockMarket subject;
    
    public DowObserver(StockMarket subject)
    {
    	if(subject == null)
    		throw new IllegalArgumentException("Parameter subject is null!");
    	
        System.out.println("DowObserver.StockObserver()");
        this.subject = subject;
    }
    
    // Observer's state

    private int dow;
    public int getDow()
    {
    	System.out.println("DowObserver.getDow()");
    	return dow;
    }
    public void setDow(int dow)
    {
    	System.out.println("DowObserver.setDow(" + dow + ")");
    	this.dow = dow;
    }
    
    @Override
    public void update()
    {
        System.out.println("DowObserver.update()");
        setDow(subject.getDow());
    }    
}
