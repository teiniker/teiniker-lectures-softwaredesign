package org.se.lab;

public class MergerCommandMAX
	implements MergerCommand
{
	@Override
	public int merge(int a, int b)
	{
		if(a > b)
			return a;
		else
			return b;
	}
}
