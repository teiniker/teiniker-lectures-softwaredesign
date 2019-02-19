package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class StateMachineTest
{
	private LightBulbSM sm;
	
	@Before
	public void setUp()
	{
		sm = new LightBulbSM();
	}
	
	
	@Test
	public void testInitialState()
	{
		assertEquals(LightBulbSM.OFF, sm.getState());		
	}
	
	@Test
	public void testTurnOff()
	{
		sm.turnOff();
		
		assertEquals(LightBulbSM.OFF, sm.getState());		
	}
	
	@Test
	public void testBurnOut()
	{
		sm.burnOut();
		
		assertEquals(LightBulbSM.OFF, sm.getState());		
	}

	@Test
	public void testTurnOn()
	{
		sm.turnOn();
		
		assertEquals(LightBulbSM.ON, sm.getState());		
	}
	
	
	@Test
	public void testTurnOnAndTurnOn()
	{
		sm.turnOn();		
		assertEquals(LightBulbSM.ON, sm.getState());
		
		sm.turnOn();
		assertEquals(LightBulbSM.ON, sm.getState());
	}
	
	
	@Test
	public void testTurnOnAndTurnOff()
	{
		sm.turnOn();		
		assertEquals(LightBulbSM.ON, sm.getState());
		
		sm.turnOff();
		assertEquals(LightBulbSM.OFF, sm.getState());
	}
	
	@Test
	public void testTurnOnAndBurnOut()
	{
		sm.turnOn();		
		assertEquals(LightBulbSM.ON, sm.getState());
		
		sm.burnOut();
		assertEquals(LightBulbSM.FINAL, sm.getState());
	}
}
