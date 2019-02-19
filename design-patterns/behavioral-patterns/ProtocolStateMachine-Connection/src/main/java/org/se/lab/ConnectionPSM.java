package org.se.lab;

/*
 * Implements a protocol state machine for the Connection interface.
 * This class can be used as a proxy for Connection implementations.  
 */
public class ConnectionPSM
	implements Connection
{
	/*
	 * Constructors
	 */
	
	public ConnectionPSM(Connection c)
	{
		setConnection(c);
		setState(State.DISCONNECTED);
	}
	
	/*
	 * Property: connection
	 */
	private Connection connection;
	private void setConnection(Connection connection)
	{
		this.connection = connection;
	}

	
	/*
	 * Property: state
	 */
	private enum State {DISCONNECTED, CONNECTED};
	private State state;
	private State getState()
	{
		return state;
	}
	private void setState(State state)
	{
		this.state = state;
	}
	

	/*
	 *  Interface Methods 
	 */
	
	public void close()
	{
		switch(getState())
		{
			case DISCONNECTED:
				throw new IllegalStateException();
			
			case CONNECTED:
				connection.close();
				setState(State.DISCONNECTED);
				break;		
		}
	}

	
	public void open()
	{
		switch(getState())
		{
			case DISCONNECTED:
				connection.open();
				setState(State.CONNECTED);
				break;		
			
			case CONNECTED:
				throw new IllegalStateException();
		}
	}

	
	public String receive()
	{
		switch(getState())
		{
			case DISCONNECTED:
				throw new IllegalStateException();
			
			case CONNECTED:
				String result = connection.receive();
				return result;
		}	
		return null;
	}

	
	public void send(String message)
	{
		switch(getState())
		{
			case DISCONNECTED:
				throw new IllegalStateException();
			
			case CONNECTED:
				connection.send(message);
				break;
		}			
	}
}
