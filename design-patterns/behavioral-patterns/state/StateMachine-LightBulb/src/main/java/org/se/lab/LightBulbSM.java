package org.se.lab;

public class LightBulbSM
{
	/*
	 * States
	 */
	
	public static final int FINAL = 0;
	public static final int ON = 1;
	public static final int OFF = 2;
	
	
	/*
	 * Constructors
	 */
	
	public LightBulbSM()
	{
	}
	
	
	/*
	 * Property: state
	 */	
	private int state = OFF;	// initial state
	protected int getState()
	{
		return state;
	}
	protected void setState(int state)
	{
		this.state = state;
	}
	
	
	/*
	 * Trigger Methods
	 */
	
	public void turnOn()
	{
		switch(state)
		{
			case OFF:
				currentOn();
				setState(ON);				
				break;
				
			case ON:
				break;

			case FINAL:
				break;
		}
	}

	
	public void turnOff()
	{
		switch(state)
		{
			case OFF:
				break;
		
			case ON:
				currentOff();
				setState(OFF);
				break;

			case FINAL:
				break;
		}		
	}
	
	
	public void burnOut()
	{
		switch(state)
		{
			case OFF:
				break;
				
			case ON:
				currentOff();
				setState(FINAL);
				break;

			case FINAL:
				break;
		}		
	}
	
	
	/*
	 * Action Methods
	 */

	protected void currentOn()
	{
		System.out.println("current ON");
	}
	
	
	protected void currentOff()
	{
		System.out.println("current OFF");
	}	
}
