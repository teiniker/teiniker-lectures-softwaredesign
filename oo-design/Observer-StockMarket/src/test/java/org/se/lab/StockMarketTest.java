package org.se.lab;

import org.junit.Test;
import org.se.lab.StockMarket;
import org.se.lab.DaxObserver;

public class StockMarketTest
{
    @Test
    public void testObserver()
    {
        // Set up the object structure
        StockMarket market = new StockMarket();        
        market.attachObserver(new DaxObserver(market));
        market.attachObserver(new DowObserver(market));
        market.attachObserver(new DowObserver(market));
        
        // Change the ConcreteSubject's state
        market.setDax(9166);
        market.setDow(17354);
        
        // Notify all attached Observer objects from a client.
//         market.notifyObservers();
    }
}
