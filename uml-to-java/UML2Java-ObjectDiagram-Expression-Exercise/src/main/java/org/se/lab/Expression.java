package org.se.lab;

import java.util.List;

public abstract class Expression
{
	/*
	 * Child access methods
	 */
	public void addExpression(Expression ex)
	{
		throw new UnsupportedOperationException();	
	}
	public List<Expression> getExpressions()
	{
		throw new UnsupportedOperationException();	
	}	
}
