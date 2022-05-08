package org.se.lab;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.ControlKey.ValidValues;

public class KeyHandlerTest 
{
	private final Logger LOG = Logger.getInstance();
	private KeyHandler handler;
	
	@Before
	public void setup()
	{
	    LOG.emptyLogList();
	    
	    // (KeyEvent) -> WindowKeyHandler -> InputKeyHandler -> DefaultKeyHandler
	    handler = new WindowKeyHandler();
		handler.setSuccessor(new InputKeyHandler());
		handler.getSuccessor().setSuccessor(new DefaultKeyHandler());				
	}
	
	
	@Test
	public void testDefaultKeyHandler()
	{
		
		KeyEvent key = new AsciiKey('X');
		handler.handleKey(key);

		List<String> expected = Arrays.asList("WindowKeyHandler: forward", "InputKeyHandler: forward", "DefaultKeyHandler: X");		
		Assert.assertEquals(expected, LOG.getLogList());
	}
	

    @Test
    public void testInputKeyHandler()
    {        
        KeyEvent key = new AsciiKey('7');
        handler.handleKey(key);

        List<String> expected = Arrays.asList("WindowKeyHandler: forward", "InputKeyHandler: 7");     
        Assert.assertEquals(expected, LOG.getLogList());
    }

    
    @Test
    public void testWindowKeyHandler()
    {
        
        KeyEvent key = new ControlKey(ValidValues.CTRL_C);
        handler.handleKey(key);

        List<String> expected = Arrays.asList("WindowKeyHandler: CTRL_C");     
        Assert.assertEquals(expected, LOG.getLogList());
    }
}
