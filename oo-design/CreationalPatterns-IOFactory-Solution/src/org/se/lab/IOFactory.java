package org.se.lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IOFactory
	implements IOFactoryOperations
{
	private final static String DIRECTORY = "doc";
	
	/*
	 * Singleton
	 */
	private IOFactory() {}
	private final static IOFactory INSTANCE = new IOFactory(); 
	public static IOFactory getInstance() { return INSTANCE; }
	
	
	/*
	 * IOFactory operations
	 */

	@Override
	public PrintWriter createPrintWriter(String fileName)
	{
		try
		{
			File f = new File(DIRECTORY, fileName);
			FileWriter writer = new FileWriter(f);
	        PrintWriter out = new PrintWriter(writer);
	        return out;
		} 
		catch (IOException e)
		{
			throw new IllegalStateException("Can't create PrintWriter to file " + fileName);
		}
	}


	@Override
	public BufferedReader createBufferedReader(String fileName)
	{
		try
		{
			File f = new File(DIRECTORY, fileName);
			FileReader reader = new FileReader(f);
			BufferedReader in = new BufferedReader(reader);
			return in;
		} 
		catch (FileNotFoundException e)
		{
			throw new IllegalStateException("Can't create BufferedReader to file " + fileName);
		}
	}
	
	
	
}
