package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Target
{
	
	/*
	 * Constructors
	 */
	public Target(String name, boolean useAttributes)
	{
		setName(name);
		setUseAttributes(useAttributes);	
		setFactory(new EchoTaskFactory());
	}
	
	
	/*
	 * Property: name:String
	 */
	private String name;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		if(name == null)
			throw new IllegalArgumentException("Parameter name is null!");
		this.name = name;
	}


	/*
	 * Property: useAttributes:boolean
	 */
	private boolean useAttributes;	
	public boolean isUseAttributes()
	{
		return useAttributes;
	}
	public void setUseAttributes(boolean useAttributes)
	{
		this.useAttributes = useAttributes;
	}
	
	
	/*
	 * Property: infos:List<EchoTask>
	 */
	private List<EchoTask> infos = new ArrayList<EchoTask>();
	public void addInfo(String info)
	{
		EchoTask task = getFactory().createEchoTask(info, isUseAttributes());
		infos.add(task);
	}	
	public List<EchoTask> getInfos()
	{
		return infos;
	}

	
	/*
	 * Property: factory:EchoTaskFactory
	 */
	private EchoTaskFactory factory;
	public EchoTaskFactory getFactory()
	{
		return factory;
	}
	public void setFactory(EchoTaskFactory factory)
	{
		this.factory = factory;
	}

	
	public String toXml()
	{
		StringBuilder xml = new StringBuilder();
		xml.append("<target name=\"").append(getName()).append("\">\n");
		for(EchoTask task : infos)
		{
			xml.append("  ").append(task.toXml()).append("\n");
		}
		xml.append("</target>");
		return xml.toString();
	}
}
