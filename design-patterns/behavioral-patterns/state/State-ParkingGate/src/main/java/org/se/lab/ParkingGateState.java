package org.se.lab;

interface ParkingGateState 	// package-private
{
	void handleCarAtGate(ParkingGate gate);
	void handleTopSwitch(ParkingGate gate);
	void handleCarJustExited(ParkingGate gate);
	void handleBottomSwitch(ParkingGate gate);
}
