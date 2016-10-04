package org.se.lab;

class CalculatorImplFast // package visibility
	implements Calculator
{
	/*
	 * Time complexity: O(1)
	 * "Der kleine Gauß" 
	 */
	public int sumOfSequence(int N)
	{
		return N*(N+1)/2;
	}
}
