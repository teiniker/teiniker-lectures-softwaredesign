package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StateTest
{
	private LightBulb sm;
	
	@Before
	public void setUp()
	{
		sm = new LightBulb();
	}
	
	
	@Test
	public void testInitialState()
	{
		Assert.assertTrue(sm.getState() instanceof LightBulbOff);		
	}
	
	@Test
	public void testTurnOff()
	{
		sm.turnOff();
		
		Assert.assertTrue(sm.getState() instanceof LightBulbOff);		
	}
	
	@Test
	public void testBurnOut()
	{
		sm.burnOut();
		
		Assert.assertTrue(sm.getState() instanceof LightBulbOff);		
	}

	@Test
	public void testTurnOn()
	{
		sm.turnOn();
		
		Assert.assertTrue(sm.getState() instanceof LightBulbOn);		
	}
	
	
	@Test
	public void testTurnOnAndTurnOn()
	{
		sm.turnOn();		
		Assert.assertTrue(sm.getState() instanceof LightBulbOn);
		
		sm.turnOn();
		Assert.assertTrue(sm.getState() instanceof LightBulbOn);
	}
	
	
	@Test
	public void testTurnOnAndTurnOff()
	{
		sm.turnOn();		
		Assert.assertTrue(sm.getState() instanceof LightBulbOn);
		
		sm.turnOff();
		Assert.assertTrue(sm.getState() instanceof LightBulbOff);
	}
	
	@Test
	public void testTurnOnAndBurnOut()
	{
		sm.turnOn();		
		Assert.assertTrue(sm.getState() instanceof LightBulbOn);
		
		sm.burnOut();
		Assert.assertTrue(sm.getState() instanceof LightBulbFinal);
	}
}
