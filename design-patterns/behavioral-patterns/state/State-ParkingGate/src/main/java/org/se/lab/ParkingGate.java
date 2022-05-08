package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class ParkingGate
{
	/*
	 * Constructor
	 */
	public ParkingGate()
	{
		setState(ParkingGateWaiting.INSTANCE); // Initial State
	}
	
	/*
	 * Reference: ---[1]-> ParkingGateState 
	 */
	private ParkingGateState state;
	protected void setState(ParkingGateState state)
	{
		this.state = state;
	}
	protected ParkingGateState getState()
	{
		return state;
	}
	
	/*
	 * Trigger
	 */
	
	public void carAtGate()
	{
		state.handleCarAtGate(this);
	}
	
	public void topSwitch()
	{
		state.handleTopSwitch(this);
	}
	
	public void carJustExited()
	{
		state.handleCarJustExited(this);
	}
	
	public void bottomSwitch()
	{
		state.handleBottomSwitch(this);
	}
	
	
	/*
	 * Actions
	 */
	
	private List<String> logs = new ArrayList<String>();
	protected List<String> getLogs()
	{
		return logs;
	}
	
	protected void stop()
	{
		logs.add("stop");
	}
	
	protected void raise()
	{
		logs.add("raise");
	}
	
	protected void lower()
	{
		logs.add("lower");
	}
}
