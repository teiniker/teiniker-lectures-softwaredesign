package org.se.lab;

public class MergerCommandXOR
	implements MergerCommand
{
	@Override
	public int merge(int a, int b)
	{
		return a ^ b;
	}
}
