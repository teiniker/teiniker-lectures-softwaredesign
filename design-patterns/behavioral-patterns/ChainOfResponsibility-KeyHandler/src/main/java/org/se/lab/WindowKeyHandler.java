package org.se.lab;

public class WindowKeyHandler extends KeyHandler 
{
	private Logger logger = Logger.getInstance();
	
	public void handleKey(KeyEvent event)
	{
	    if (event instanceof ControlKey)
		{
			logger.debug("WindowKeyHandler: " + event.toString());
		}
		else
		{
		    logger.debug("WindowKeyHandler: forward");
			super.handleKey(event);
		}		
	}
}
