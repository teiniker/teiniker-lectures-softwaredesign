package org.se.lab;

/**
 * This interface declares a factory method. 
 * 
 * Note that a class that implements one or more creation methods 
 * (or factory methods) is called a "factory".
 */
public interface TableFactory
{
	/*
	 * This is the minimal implementation of a Singleton pattern.
	 */
	TableFactory INSTANCE = new TableFactoryImpl();
	
	
    /**
     * This factory method returns an object of type PersonTable
     * (an interface).
     */
    PersonTable createPersonTable();    
}

