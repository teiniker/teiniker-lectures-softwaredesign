package org.se.lab;


public class Controller
{
	/*
	 * Constructor injection
	 */
	
	public Controller(Motor motor)
	{
		setMotor(motor);
	}
	
	
	/*
	 * Property: state:State
	 */
	private ControllerState state = ControllerBottom.INSTANCE; // Initial state
	ControllerState getState()
	{
		return state;
	}
	void setState(ControllerState state)
	{
		if(motor == null)
			throw new IllegalArgumentException();
		this.state = state;
	}


	/*
	 * Association: motor:Motor
	 */
	private Motor motor;
	Motor getMotor()
	{
		return motor;
	}
	void setMotor(Motor motor)
	{
		this.motor = motor;
	}

	
	/*
	 * Trigger methods
	 */
	
	public void pushUpButton()
	{
		state.handlePushUpButton(this);
	}
	
	public void pushDownButton()
	{
		state.handlePushDownButton(this);
	}
	
	public void endSwitchTop()
	{
		state.handleEndSwitchTop(this);
	}

	public void endSwitchBottom()
	{
		state.handleEndSwitchBottom(this);
	}
}
