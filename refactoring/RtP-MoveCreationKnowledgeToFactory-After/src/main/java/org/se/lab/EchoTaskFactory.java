package org.se.lab;

import org.se.lab.EchoTask;
import org.se.lab.EchoTaskUsingAttributes;
import org.se.lab.EchoTaskUsingText;

public class EchoTaskFactory
{

	public EchoTask createEchoTask(String info, boolean useAttributes)
	{
		EchoTask task = null;
		if(useAttributes)
		{
			task = new EchoTaskUsingAttributes(info);
		}
		else
		{
			task = new EchoTaskUsingText(info);
		}
		return task;
	}

}
