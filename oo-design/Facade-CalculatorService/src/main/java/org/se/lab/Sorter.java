package org.se.lab;

import java.util.Collections;
import java.util.List;

class Sorter // package private
{
    
    public void sort(final List<Double> data)
    {
    	if(data == null)
    		throw new NullPointerException("data");
        Collections.sort(data);
    }
    
    
    public void reverse(final List<Double> data)
    {
    	if(data == null)
    		throw new NullPointerException("data");
        Collections.reverse(data);
    }
}
