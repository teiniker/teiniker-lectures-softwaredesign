package org.se.lab;

import java.io.BufferedReader;
import java.io.PrintWriter;

public interface IOFactoryOperations
{
	PrintWriter createPrintWriter(String fileName);

	BufferedReader createBufferedReader(String fileName);
}
