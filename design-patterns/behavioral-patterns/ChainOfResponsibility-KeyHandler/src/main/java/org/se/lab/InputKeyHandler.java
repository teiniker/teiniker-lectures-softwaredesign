package org.se.lab;

class InputKeyHandler extends KeyHandler   // package private
{
	private Logger logger = Logger.getInstance();
	
	public void handleKey(KeyEvent event)
	{
	    if (event instanceof AsciiKey)
		{
			AsciiKey key = (AsciiKey) event;
			
			if (key.getValue() >= '0' && key.getValue() <= '9')
			{
				logger.debug("InputKeyHandler: " + event.toString());
			}
			else
			{
			    logger.debug("InputKeyHandler: forward");
				super.handleKey(event);
			}
		}
		else
		{
		    logger.debug("InputKeyHandler: forward");
			super.handleKey(event);
		}
	}
}
