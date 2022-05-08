package org.se.lab;

class DefaultKeyHandler extends KeyHandler 	// package private
{
	private final Logger logger = Logger.getInstance();
	
	public void handleKey(KeyEvent event)
	{
		logger.debug("DefaultKeyHandler: " + event.toString());
	}
}
