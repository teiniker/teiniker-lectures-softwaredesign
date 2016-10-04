package org.se.lab;

import java.util.Collections;
import java.util.List;

class Evaluator // package private
{
    public double min(final List<Double> data)
    {
    	if(data == null)
    		throw new NullPointerException("data");    	
        return Collections.min(data);
    }
    
    public double max(final List<Double> data)
    {
    	if(data == null)
    		throw new NullPointerException("data");    	
        return Collections.max(data);
    }
    
    public double sum(final List<Double> data)
    {
    	if(data == null)
    		throw new NullPointerException("data");    	
        double result = 0.0;
        for(double d: data)
        {
            result += d;
        }
        return result;
    }
    
    public double mean(final List<Double> data)
    {
    	if(data == null)
    		throw new NullPointerException("data");    	
        return sum(data)/data.size();
    }
}
