package org.se.lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IOFactoryTest
{
	private final static String DIRECTORY = "doc";
	
	@Before
	public void setup()
	{
		File f = new File(DIRECTORY,"myfile");
		if(f.exists())
			f.delete();
	}
	
	@Test
	public void testCreatePrintWriter()
	{
		PrintWriter out = IOFactory.getInstance().createPrintWriter("myfile");
        
		out.println("0000 0000: 00 01 02 03 04 05 06 07 08 09 0a 0b 0c 0d 0e 0f");
        out.close();
         
        File f = new File(DIRECTORY,"myfile");
        Assert.assertTrue(f.exists());
	}

	
	@Test
	public void testCreateBufferedReader() throws IOException
	{
		BufferedReader in = IOFactory.getInstance().createBufferedReader("data.txt");

		StringBuilder s = new StringBuilder();
		String l;
		while((l = in.readLine()) != null)
		{
			s.append(l).append("\n");
		}
		
		in.close();
	
		final String EXPECTED = 
				"0000 0000: 00 01 02 03 04 05 06 07 08 09 0a 0b 0c 0d 0e 0f\n" +
				"0000 0010: 00 01 02 03 04 05 06 07 08 09 0a 0b 0c 0d 0e 0f\n";
				
		Assert.assertEquals(EXPECTED, s.toString());
	}
}
