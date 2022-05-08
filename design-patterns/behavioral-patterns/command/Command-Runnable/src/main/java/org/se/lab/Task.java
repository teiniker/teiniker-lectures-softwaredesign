package org.se.lab;


public class Task
	implements Runnable
{
	/*
	 * Constructor
	 */
	public Task(long ms)
	{
		this.ms = ms;	
	}
	
	/*
	 * Property ms:long
	 */
	private final long ms;
	public long getMs()
	{
		return ms;
	}


	@Override
	public void run()
	{
		System.out.println("run() - begin: " + Thread.currentThread().getId());
		waitSuspended();
		System.out.println("run() - end  : " + Thread.currentThread().getId());
	}

	
	private void waitSuspended()
	{
		try
		{
			Thread.sleep(getMs());
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}		
	}

}
