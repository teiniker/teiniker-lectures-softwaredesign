package org.se.lab;

import java.util.List;

class Validator // package private
{
    public boolean isValid(final double value, 
    		final double min, final double max)
    {
        if((value < min) || (value > max))
            return false;
        else
            return true;    
    }
    
    public boolean isValid(final List<Double> data)
    {
        if((data == null) || data.size() == 0)
            return false;
        else
            return true;
    }
}
