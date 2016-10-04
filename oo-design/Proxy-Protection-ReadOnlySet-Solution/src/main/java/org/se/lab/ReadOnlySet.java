package org.se.lab;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class ReadOnlySet<E>
	implements Set<E>
{
	/*
	 * Association: ---[1]-> set:Set<E>
	 */
	private final Set<E> set;

	public ReadOnlySet(Set<E> set)
	{
		if(set == null)
			throw new IllegalArgumentException();
		this.set = set;
	}

	@Override
	public int size()
	{
		return set.size();
	}

	@Override
	public boolean isEmpty()
	{
		return set.isEmpty();
	}

	@Override
	public boolean contains(Object o)
	{
		return set.contains(o);
	}

	@Override
	public Iterator<E> iterator()
	{	
		return new ReadOnlyIterator<E>(set.iterator());
	}

	@Override
	public Object[] toArray()
	{
		return set.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a)
	{
		return set.toArray(a);
	}

	@Override
	public boolean add(E e)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o)
	{
		throw new UnsupportedOperationException();	
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return set.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear()
	{
		throw new UnsupportedOperationException();
	}
}
