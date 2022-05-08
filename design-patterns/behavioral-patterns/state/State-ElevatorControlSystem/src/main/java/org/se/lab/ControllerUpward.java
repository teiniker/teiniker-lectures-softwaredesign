package org.se.lab;

class ControllerUpward
	implements ControllerState
{
	public static final ControllerState INSTANCE = new ControllerUpward();
	private ControllerUpward() {}
	
	@Override
	public void handlePushUpButton(Controller c)
	{
		// do nothing
	}

	@Override
	public void handlePushDownButton(Controller c)
	{
		c.getMotor().runCounterclockwise();
		c.setState(ControllerDownward.INSTANCE);
	}

	@Override
	public void handleEndSwitchTop(Controller c)
	{
		c.getMotor().stop();
		c.setState(ControllerTop.INSTANCE);
	}

	@Override
	public void handleEndSwitchBottom(Controller c)
	{
		throw new IllegalStateException();
	}
}
