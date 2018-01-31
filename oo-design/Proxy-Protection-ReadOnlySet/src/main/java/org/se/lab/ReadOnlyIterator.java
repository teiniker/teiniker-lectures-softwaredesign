package org.se.lab;

import java.util.Iterator;

public class ReadOnlyIterator<E>
	implements Iterator<E>
{
	/*
	 * Constructor
	 */
	public ReadOnlyIterator(Iterator<E> it)
	{
		this.it = it;
	}

	/*
	 * Reference: ---[1]-> Iterator<E>
	 */
	private Iterator<E> it;
	
	
	@Override
	public boolean hasNext()
	{
		return it.hasNext();	
	}

	@Override
	public E next()
	{
		return it.next();
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();		
	}
}
