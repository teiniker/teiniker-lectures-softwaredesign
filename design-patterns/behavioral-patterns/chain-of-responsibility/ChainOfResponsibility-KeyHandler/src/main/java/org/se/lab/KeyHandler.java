package org.se.lab;

public abstract class KeyHandler
{
	/*
	 * Reference to next CharacterHandler
	 */
	private KeyHandler successor;
	public KeyHandler getSuccessor() 
	{
		return successor;
	}
	public void setSuccessor(KeyHandler successor) 
	{
		this.successor = successor;
	}
	
	/*
	 * Default Handler Implementation
	 */
	public void handleKey(KeyEvent event)
	{
		if (getSuccessor() != null)
		{
			getSuccessor().handleKey(event);
		}
		else
		{
			throw new IllegalArgumentException("ERROR: No valid handler found!");
		}
	}
}
