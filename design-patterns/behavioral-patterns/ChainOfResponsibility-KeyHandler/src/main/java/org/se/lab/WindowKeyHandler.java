package org.se.lab;

class WindowKeyHandler extends KeyHandler // package private
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
