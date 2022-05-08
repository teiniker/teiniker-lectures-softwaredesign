package org.se.lab;

class ControllerDownward
	implements ControllerState
{
	public static final ControllerState INSTANCE = new ControllerDownward();
	private ControllerDownward() {}
	
	@Override
	public void handlePushUpButton(Controller c)
	{
		c.getMotor().runClockwise();
		c.setState(ControllerUpward.INSTANCE);
	}

	@Override
	public void handlePushDownButton(Controller c)
	{
		// do nothing
	}

	@Override
	public void handleEndSwitchTop(Controller c)
	{
		throw new IllegalStateException();
	}

	@Override
	public void handleEndSwitchBottom(Controller c)
	{
		c.getMotor().stop();
		c.setState(ControllerBottom.INSTANCE);
	}
}
