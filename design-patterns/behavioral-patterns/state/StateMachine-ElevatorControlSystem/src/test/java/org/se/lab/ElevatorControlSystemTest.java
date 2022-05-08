package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ElevatorControlSystemTest
{
	private ControllerSM controler;
	private Motor motor;
	
	@Before
	public void setup()
	{
		motor = new Motor();
		controler = new ControllerSM(motor);
	}

	
	@Test
	public void testUpAndDown()
	{
		controler.pushUpButton();
		controler.endSwitchTop();
		controler.pushDownButton();
		controler.endSwitchBottom();
		
		Assert.assertEquals("[clockwise, stop, counterclockwise, stop]", motor.log.toString());
	}

	@Test
	public void testUpAndDownAndUpAndDown()
	{
		controler.pushUpButton();
		controler.pushDownButton();
		controler.pushUpButton();
		controler.endSwitchTop();
		
		controler.pushDownButton();
		controler.pushUpButton();
		controler.pushDownButton();		
		controler.endSwitchBottom();
		
		Assert.assertEquals("[clockwise, counterclockwise, clockwise, stop, counterclockwise, clockwise, counterclockwise, stop]", motor.log.toString());
	}

	
	/*
	 * BOTTOM state
	 */
		
	@Test
	public void testEndSwitchBottom()
	{
		controler.endSwitchBottom();
		Assert.assertEquals("[]", motor.log.toString());
	}

	@Test(expected=IllegalStateException.class)
	public void testEndSwitchTop()
	{
		controler.endSwitchTop();
	}
	

	/*
	 * UPWARD state
	 */
	
	@Test
	public void testUpUp()
	{
		controler.pushUpButton();
		controler.pushUpButton();
		
		Assert.assertEquals("[clockwise]", motor.log.toString());
	}

	@Test
	public void testUpEndSwitchTop()
	{
		controler.pushUpButton();
		controler.endSwitchTop();
		
		Assert.assertEquals("[clockwise, stop]", motor.log.toString());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testUpEndSwitchBottom()
	{
		controler.pushUpButton();
		controler.endSwitchBottom();
	}
	
	
	/*
	 * TOP state
	 */
	@Test
	public void testUpUpUp()
	{
		controler.pushUpButton();
		controler.pushUpButton();
		controler.pushUpButton();
		
		Assert.assertEquals("[clockwise]", motor.log.toString());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testUpEndSwitchTopEndSwitchBottom()
	{
		controler.pushUpButton();
		controler.endSwitchTop();
		controler.endSwitchBottom();
	}
	
	
	/*
	 * DOWNWARD state
	 */
	
	@Test
	public void testUpDownDown()
	{
		controler.pushUpButton();
		controler.pushDownButton();
		controler.pushDownButton();
		
		Assert.assertEquals("[clockwise, counterclockwise]", motor.log.toString());
	}
	
	@Test
	public void testUpDownUp()
	{
		controler.pushUpButton();
		controler.pushDownButton();
		controler.pushUpButton();
		
		Assert.assertEquals("[clockwise, counterclockwise, clockwise]", motor.log.toString());
	}
	
	@Test
	public void testUpDownEndSwitchBottom()
	{
		controler.pushUpButton();
		controler.pushDownButton();
		controler.endSwitchBottom();
		
		Assert.assertEquals("[clockwise, counterclockwise, stop]", motor.log.toString());
	}

	@Test(expected = IllegalStateException.class)
	public void testUpDownEndSwitchTop()
	{
		controler.pushUpButton();
		controler.pushDownButton();
		controler.endSwitchTop();
	}
}
