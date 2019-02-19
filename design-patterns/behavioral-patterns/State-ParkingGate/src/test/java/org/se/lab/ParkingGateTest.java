package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingGateTest
{
	private ParkingGate gate;
	
	@Before
	public void setup()
	{
		gate = new ParkingGate();
	}

	@Test
	public void testInitialState()
	{
		Assert.assertEquals(ParkingGateWaiting.INSTANCE, gate.getState());
	}

	@Test
	public void testHappyPath()
	{
		gate.carAtGate();
		Assert.assertEquals(ParkingGateRaising.INSTANCE, gate.getState());
		gate.topSwitch();
		Assert.assertEquals(ParkingGateOpen.INSTANCE, gate.getState());
		gate.carJustExited();
		Assert.assertEquals(ParkingGateLowering.INSTANCE, gate.getState());
		gate.bottomSwitch();
		Assert.assertEquals(ParkingGateWaiting.INSTANCE, gate.getState());
		
		String expected = "[raise, stop, lower, stop]";
		Assert.assertEquals(expected, gate.getLogs().toString());
	}

	@Test
	public void testWaiting()
	{
		gate.topSwitch();
		gate.carJustExited();
		gate.bottomSwitch();
		Assert.assertEquals(ParkingGateWaiting.INSTANCE, gate.getState());
		
		String expected = "[]";
		Assert.assertEquals(expected, gate.getLogs().toString());		
	}


	@Test
	public void testRaising()
	{
		gate.carAtGate();
		
		gate.carAtGate();
		gate.carJustExited();
		gate.bottomSwitch();
		Assert.assertEquals(ParkingGateRaising.INSTANCE, gate.getState());
		
		String expected = "[raise]";
		Assert.assertEquals(expected, gate.getLogs().toString());		
	}

	@Test
	public void testOpen()
	{
		gate.carAtGate();
		gate.topSwitch();
		
		gate.carAtGate();
		gate.topSwitch();
		gate.bottomSwitch();
		Assert.assertEquals(ParkingGateOpen.INSTANCE, gate.getState());
		
		String expected = "[raise, stop]";
		Assert.assertEquals(expected, gate.getLogs().toString());		
	}

	@Test
	public void testLowering()
	{
		gate.carAtGate();
		gate.topSwitch();
		gate.carJustExited();
		
		gate.carAtGate();
		gate.topSwitch();
		gate.carJustExited();
		Assert.assertEquals(ParkingGateLowering.INSTANCE, gate.getState());
		
		String expected = "[raise, stop, lower]";
		Assert.assertEquals(expected, gate.getLogs().toString());		
	}
}
