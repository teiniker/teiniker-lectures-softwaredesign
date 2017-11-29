package org.se.lab;

import org.junit.Assert;
import org.junit.Test;


public class UrlBuilderTest 
{
	
	@Test
	public void testHttp()
	{
		String url = new UrlBuilder()
		        .http()
				.host("www.google.com")
				.port(80)
				.application("search")
				.parameter("q", "httpclient")
				.parameter("btnG", "Google+Search")
				.parameter("aq", "f")
				.parameter("oq", "")
				.build();
		
		String expected = "http://www.google.com:80/search?q=httpclient&btnG=Google+Search&aq=f&oq=";
		Assert.assertEquals(expected, url);
	}
	
	@Test
	public void testHttps()
	{
	    String url  = new UrlBuilder()
	            .https()
				.host("mail.fh-joanneum.at")
				.application("exchange")
				.build();
		
		String expected = "https://mail.fh-joanneum.at/exchange/";
		Assert.assertEquals(expected, url);
	}
	
	@Test
	public void testFtp()
	{
		String url = new UrlBuilder()
		        .ftp()
				.host("mesen.fh-joanneum.at")
				.application("common")
				.build();
		
		String expected = "ftp://mesen.fh-joanneum.at/common/";
		Assert.assertEquals(expected, url);
	}
}
