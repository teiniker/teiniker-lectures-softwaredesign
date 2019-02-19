package org.se.lab;

public class RedApple 
	extends Node
{
	@Override
	public void accept(VisitorAppleTree v)
	{
		v.visit(this);
	}
}
