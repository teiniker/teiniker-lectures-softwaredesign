package org.se.lab;

import java.util.function.Consumer;
import org.junit.Test;

public class ConsumerTest
{
	@Test
	public void testAccept()
	{
		Consumer<String> printConsumer = s -> System.out.println("Input: " + s);
		printConsumer.accept("ConsumerTest!");
	}

	@Test
	public void testAndThen()
	{
		Consumer<String> printString = s -> System.out.println("Input: " + s);
		Consumer<String> printLength = s -> System.out.println("Length: " + s.length());
		printString.andThen(printLength).accept("ConsumerTest!");
	}
}
