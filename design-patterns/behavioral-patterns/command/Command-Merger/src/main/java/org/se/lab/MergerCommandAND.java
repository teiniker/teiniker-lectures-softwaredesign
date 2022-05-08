package org.se.lab;

public class MergerCommandAND
	implements MergerCommand
{
	@Override
	public int merge(int a, int b)
	{
		return a & b;
	}
}
