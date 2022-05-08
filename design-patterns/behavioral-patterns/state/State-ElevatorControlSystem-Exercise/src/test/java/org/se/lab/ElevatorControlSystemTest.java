package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ElevatorControlSystemTest
{
	private Controller controller;
	private Motor motor;
	
	@Before
	public void setup()
	{
		motor = new Motor();
		controller = new Controller(motor);
	}

	
	@Test
	public void testUpAndDown()
	{
		controller.pushUpButton();
		controller.endSwitchTop();
		controller.pushDownButton();
		controller.endSwitchBottom();
		
		Assert.assertEquals("[clockwise, stop, counterclockwise, stop]", motor.log.toString());
	}

	@Test
	public void testUpAndDownAndUpAndDown()
	{
		controller.pushUpButton();
		controller.pushDownButton();
		controller.pushUpButton();
		controller.endSwitchTop();
		
		controller.pushDownButton();
		controller.pushUpButton();
		controller.pushDownButton();
		controller.endSwitchBottom();
		
		Assert.assertEquals("[clockwise, counterclockwise, clockwise, stop, counterclockwise, clockwise, counterclockwise, stop]", motor.log.toString());
	}

	
	/*
	 * BOTTOM state
	 */
		
	@Test
	public void testEndSwitchBottom()
	{
		controller.endSwitchBottom();
		Assert.assertEquals("[]", motor.log.toString());
	}

	@Test(expected=IllegalStateException.class)
	public void testEndSwitchTop()
	{
		controller.endSwitchTop();
	}
	

	/*
	 * UPWARD state
	 */
	
	@Test
	public void testUpUp()
	{
		controller.pushUpButton();
		controller.pushUpButton();
		
		Assert.assertEquals("[clockwise]", motor.log.toString());
	}

	@Test
	public void testUpEndSwitchTop()
	{
		controller.pushUpButton();
		controller.endSwitchTop();
		
		Assert.assertEquals("[clockwise, stop]", motor.log.toString());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testUpEndSwitchBottom()
	{
		controller.pushUpButton();
		controller.endSwitchBottom();
	}
	
	
	/*
	 * TOP state
	 */
	@Test
	public void testUpUpUp()
	{
		controller.pushUpButton();
		controller.pushUpButton();
		controller.pushUpButton();
		
		Assert.assertEquals("[clockwise]", motor.log.toString());
	}
	
	@Test(expected = IllegalStateException.class)
	public void testUpEndSwitchTopEndSwitchBottom()
	{
		controller.pushUpButton();
		controller.endSwitchTop();
		controller.endSwitchBottom();
	}
	
	
	/*
	 * DOWNWARD state
	 */
	
	@Test
	public void testUpDownDown()
	{
		controller.pushUpButton();
		controller.pushDownButton();
		controller.pushDownButton();
		
		Assert.assertEquals("[clockwise, counterclockwise]", motor.log.toString());
	}
	
	@Test
	public void testUpDownUp()
	{
		controller.pushUpButton();
		controller.pushDownButton();
		controller.pushUpButton();
		
		Assert.assertEquals("[clockwise, counterclockwise, clockwise]", motor.log.toString());
	}
	
	@Test
	public void testUpDownEndSwitchBottom()
	{
		controller.pushUpButton();
		controller.pushDownButton();
		controller.endSwitchBottom();
		
		Assert.assertEquals("[clockwise, counterclockwise, stop]", motor.log.toString());
	}

	@Test(expected = IllegalStateException.class)
	public void testUpDownEndSwitchTop()
	{
		controller.pushUpButton();
		controller.pushDownButton();
		controller.endSwitchTop();
	}
}
