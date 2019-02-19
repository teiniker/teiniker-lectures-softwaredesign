package org.se.lab;

public interface ParkingGateState
{
	void handleCarAtGate(ParkingGate gate);
	void handleTopSwitch(ParkingGate gate);
	void handleCarJustExited(ParkingGate gate);
	void handleBottomSwitch(ParkingGate gate);
}
