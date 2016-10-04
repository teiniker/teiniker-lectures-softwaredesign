package org.se.lab;

import java.util.List;

/*
 * The facade class knows which subsystem classes are responsible for a request
 * and delegates client requests to appropriate system objects.
 */
public class CalculatorService
{
    private final Validator check = new Validator(); 
    private final Evaluator eval = new Evaluator();
    private final Logger logger = new Logger();
    
    /*
     * The facade class puts all pieces together to handle this 
     * method call.
     */
    public double calculateMeanValue(final List<Double> data)
    {   
        // delegate to Logger
        logger.log(Logger.LOG_DEBUG, "calculateMeanValue(" + data + ")");
     
        // delegate to Validator and Logger
        if(!check.isValid(data))
        {
            final String s = "Data is invalid!";
            logger.log(Logger.LOG_ERROR, s);
            throw new IllegalArgumentException(s);
        }
        
        // delegate to Evaluator
        double mean = eval.mean(data);        
        return mean;
    }
}
