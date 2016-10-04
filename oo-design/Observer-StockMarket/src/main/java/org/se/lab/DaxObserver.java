package org.se.lab;

/**
 * This ConcreteObserver class maintains a reference to a ConcreteSubject
 * (StockMarket) object and stores state that should stay consistent with the 
 * subject's state.
 * 
 * DaxObserver also implements the Observer updating interface to keep its
 * state consistent with the subject's state.
 */
public class DaxObserver
    implements Observer
{
    private StockMarket subject;
    
    public DaxObserver(StockMarket subject)
    {
    	if(subject == null)
    		throw new IllegalArgumentException("Parameter subject is null!");
    	
        System.out.println("DaxObserver.StockObserver()");
        this.subject = subject;
    }
    
    // Observer's state

    private int dax;
    public int getDax()
    {
    	System.out.println("DaxObserver.getDax()");
    	return dax;
    }
    public void setDax(int dax)
    {
    	System.out.println("DaxObserver.setDax(" + dax + ")");
    	this.dax = dax;
    }
    
    @Override
    public void update()
    {
        System.out.println("DaxObserver.update()");
        setDax(subject.getDax());
    }    
}
