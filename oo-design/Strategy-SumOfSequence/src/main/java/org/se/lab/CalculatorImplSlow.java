package org.se.lab;

class CalculatorImplSlow // package visibility
	implements Calculator
{
	/*
	 * Time complexity: O(N)
	 * This is the brute force implementation.
	 */
	public int sumOfSequence(int N)
	{
		int result = 0;
		for(int i=1; i<=N; i++)
			result += i;
		return result;
	}
}
