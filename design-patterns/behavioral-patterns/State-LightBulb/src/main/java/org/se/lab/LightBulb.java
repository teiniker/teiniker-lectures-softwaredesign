package org.se.lab;

public class LightBulb
{
	public LightBulb()
	{
		setState(LightBulbOff.INSTANCE);
	}
	
    /* 
     * Handle state
     */
    private LightBulbState state;
    protected void setState(LightBulbState state)
    {
        if(state == null)
            throw new IllegalArgumentException("State parameter is null!");        
        this.state = state;
    }
    protected LightBulbState getState()
    {
    	return state;
    }
    
    
    public void turnOn()
    {
        state.handleTurnOn(this);        
    }
    
    public void turnOff()
    {
    	state.handleTurnOff(this);
    }
    
    public void burnOut()
    {
    	state.handleBurnOut(this);
    }
}

