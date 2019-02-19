package org.se.lab;

public class GreenApple 
	extends Node
{
	@Override
	public void accept(VisitorAppleTree v)
	{
		v.visit(this);
	}
	
}
