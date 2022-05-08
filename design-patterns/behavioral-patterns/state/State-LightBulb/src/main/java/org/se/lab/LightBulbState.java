package org.se.lab;

public interface LightBulbState
{
	void handleTurnOn(LightBulb b);
	void handleTurnOff(LightBulb b);
	void handleBurnOut(LightBulb b);
}
