package org.se.lab;

public class Main
{
	public static void main(String... args)
	{
		System.out.println("main() - begin");
		Thread t1 = new Thread(new Task(1000));
		Thread t2 = new Thread(new Task(3000));
		Thread t3 = new Thread(new Task(2000));
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("main() - end");
	}
}
