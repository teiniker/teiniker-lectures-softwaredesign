package org.se.lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Assert;
import org.junit.Test;

public class IOTest
{
	private final static String DIRECTORY = "doc";

	@Test
	public void testPrintWriter() throws IOException
	{
		String fileName = "myfile";
		File f = new File(DIRECTORY, fileName);
		FileWriter writer = new FileWriter(f);
        PrintWriter out = new PrintWriter(writer);

        out.println("0000 0000: 00 01 02 03 04 05 06 07 08 09 0a 0b 0c 0d 0e 0f");
        out.close();
         
        Assert.assertTrue(f.exists());
	}

	
	@Test
	public void testBufferedReader() throws IOException
	{
		String fileName = "data.txt";

		File f = new File(DIRECTORY, fileName);
		FileReader reader = new FileReader(f);
		BufferedReader in = new BufferedReader(reader);

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
