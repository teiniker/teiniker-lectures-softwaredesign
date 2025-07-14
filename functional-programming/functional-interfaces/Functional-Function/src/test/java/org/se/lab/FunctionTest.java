package org.se.lab;

import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

public class FunctionTest
{
	@Test
	public void testApply()
	{
		Function<String, String> toUpperCase = (s) -> s.toUpperCase();

		Assert.assertEquals("SIMPSONS", toUpperCase.apply("simpsons"));
	}

	@Test
	public void testAndThen()
	{
		Function<String, String> toUpperCase = (s) -> s.toUpperCase();
		Function<String, Integer> stringLength = (s) -> s.length();

		Assert.assertEquals(Integer.valueOf(8), toUpperCase.andThen(stringLength).apply("simpsons"));
	}

	@Test
	public void testCompose()
	{
		Function<String, String> toUpperCase = (s) -> s.toUpperCase();
		Function<String, Integer> stringLength = (s) -> s.length();

		System.out.println(stringLength.compose(toUpperCase).apply("simpsons"));
	}
}
