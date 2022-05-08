package org.se.lab;

public interface ControllerState
{
	void handlePushUpButton(Controller c);
	
	void handlePushDownButton(Controller c);
	
	void handleEndSwitchTop(Controller c);

	void handleEndSwitchBottom(Controller c);
}
