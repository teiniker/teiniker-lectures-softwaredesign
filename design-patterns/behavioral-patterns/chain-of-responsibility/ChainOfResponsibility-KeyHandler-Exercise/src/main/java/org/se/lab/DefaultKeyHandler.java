package org.se.lab;

public class DefaultKeyHandler extends KeyHandler 
{
	private final Logger logger = Logger.getInstance();
	
	public void handleKey(KeyEvent event)
	{
		logger.debug("DefaultKeyHandler: " + event.toString());
	}
}
