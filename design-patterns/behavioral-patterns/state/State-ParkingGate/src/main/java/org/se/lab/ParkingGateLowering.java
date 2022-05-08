package org.se.lab;

class ParkingGateLowering  // package private
	implements ParkingGateState
{
	/*
	 * Singleton
	 */
	public static final ParkingGateState INSTANCE = new ParkingGateLowering();
	private ParkingGateLowering() {}
	
	
	@Override
	public void handleCarAtGate(ParkingGate gate)
	{
		// Do nothing	
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
		gate.stop();
		gate.setState(ParkingGateWaiting.INSTANCE);
	}
}
