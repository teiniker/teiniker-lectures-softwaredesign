package org.se.lab;

public class ControllerSM
{
	/*
	 * Constructor injection
	 */
	public ControllerSM(Motor motor) 
	{
		if(motor == null)
			throw new IllegalArgumentException();
		this.motor = motor;
	}
	
		
	/*
	 * Property: state:State
	 */
	private enum State {BOTTOM, UPWARD, TOP, DOWNWARD}
	private State state = State.BOTTOM; // Initial state
	private State getState()
	{
		return state;
	}
	private void setState(State state)
	{
		this.state = state;
	}

		
	/*
	 * Association: motor:Motor
	 */
	private Motor motor;
	public Motor getMotor()
	{
		return motor;
	}
	public void setMotor(Motor motor)
	{
		this.motor = motor;
	}
	
	
	/*
	 * Trigger methods
	 */
	
	public void pushUpButton()
	{
		switch(getState())
		{
			case BOTTOM:
				getMotor().runClockwise();
				setState(State.UPWARD);
				break;
								
			case DOWNWARD:
				getMotor().runClockwise();
				setState(State.UPWARD);
				break;
				
			case UPWARD:
				// do nothing
				break;

			case TOP:
				// do nothing
				break;
		}
	}
	
	public void pushDownButton()
	{
		switch(getState())
		{
			case BOTTOM:
				// do nothing
				break;

			case DOWNWARD:
				// do nothing
				break;
				
			case UPWARD:
				getMotor().runCounterclockwise();
				setState(State.DOWNWARD);
				break;

			case TOP:
				getMotor().runCounterclockwise();
				setState(State.DOWNWARD);
				break;
		}		
	}
	
	public void endSwitchTop()
	{
		switch(getState())
		{
			case BOTTOM:
				throw new IllegalStateException();

			case DOWNWARD:
				throw new IllegalStateException();
								
			case UPWARD:
				getMotor().stop();
				setState(State.TOP);
				break;
				
			case TOP:
				// do nothing
				break;
		}				
	}

	public void endSwitchBottom()
	{
		switch(getState())
		{
			case BOTTOM:
				// do nothing
				break;
				
			case UPWARD:
				throw new IllegalStateException();

			case TOP:
				throw new IllegalStateException();
				
			case DOWNWARD:
				getMotor().stop();
				setState(State.BOTTOM);
				break;
		}						
	}
}
