package org.se.lab;

public class CalculatorFactory
{
	/*
	 * Singleton
	 */
	private static final CalculatorFactory INSTANCE = new CalculatorFactory();
	private CalculatorFactory() {}
	public static CalculatorFactory getInstance() { return INSTANCE;}
	
	
	/*
	 * Create methods
	 */
	public Calculator createCalculator(TimeComplexity strategy)
	{
		Calculator result = null;
		switch(strategy) 
		{
			case CONSTANT:
				result =  new CalculatorImplFast();
				break;
				
			case LINEAR:
				result = new CalculatorImplSlow();
				break;
				
			// other implementations ...
			default:
				throw new IllegalArgumentException();
		}		
		return result;
	}
}
