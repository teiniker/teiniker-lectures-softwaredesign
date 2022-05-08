package org.se.lab;

class ParkingGateWaiting // package private
	implements ParkingGateState
{
	/*
	 * Singleton
	 */
	public static final ParkingGateState INSTANCE = new ParkingGateWaiting();
	private ParkingGateWaiting() {}
	
	@Override
	public void handleCarAtGate(ParkingGate gate)
	{
		gate.raise();
		gate.setState(ParkingGateRaising.INSTANCE);		
	}

	@Override
	public void handleTopSwitch(ParkingGate gate)
	{
		// Do nothing
	}

	@Override
	public void handleCarJustExited(ParkingGate gate)
	{
		// Do nothing
	}

	@Override
	public void handleBottomSwitch(ParkingGate gate)
	{
		// Do nothing
	}
}
