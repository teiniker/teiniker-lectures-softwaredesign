package org.se.lab;

public class Leaf extends Node
{
	@Override
	public void accept(VisitorAppleTree v)
	{
		v.visit(this);		
	}
}
