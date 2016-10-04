package org.se.lab;

import java.util.List;

public interface TextFile
{
	/*
	 * Return the number of lines in the text file.
	 */
	int numberOfLines();
	
	/*
	 * Return the length of the whole text file (number of characters).
	 */
	int length();
	
	
	/*
	 * Return the given line of the text file (index starting with 0).
	 */
	String getLine(int i);
	

	/*
	 * Return the text file as a list of strings. Each line of the text
	 * file is stored as an String element in the list.
	 */
	List<String> asList();
}
