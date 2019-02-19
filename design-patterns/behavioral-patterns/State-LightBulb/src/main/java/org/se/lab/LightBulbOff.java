package org.se.lab;

class LightBulbOff
	implements LightBulbState
{
	public static final LightBulbState INSTANCE = new LightBulbOff();

	@Override
	public void handleTurnOn(LightBulb b)
	{
		System.out.println("current ON");
		b.setState(LightBulbOn.INSTANCE);
	}

	@Override
	public void handleTurnOff(LightBulb b)
	{
		// do nothing
	}

	@Override
	public void handleBurnOut(LightBulb b)
	{	
		// do nothing
	}
}
