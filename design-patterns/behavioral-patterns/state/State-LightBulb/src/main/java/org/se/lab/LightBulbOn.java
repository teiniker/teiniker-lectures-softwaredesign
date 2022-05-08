package org.se.lab;

class LightBulbOn
	implements LightBulbState
{
	public static final LightBulbState INSTANCE = new LightBulbOn();

	@Override
	public void handleTurnOn(LightBulb b)
	{
		// do nothing
	}

	@Override
	public void handleTurnOff(LightBulb b)
	{
		System.out.println("current OFF");
		b.setState(LightBulbOff.INSTANCE);			
	}

	@Override
	public void handleBurnOut(LightBulb b)
	{
		System.out.println("current OFF");
		b.setState(LightBulbFinal.INSTANCE);		
	}
}
