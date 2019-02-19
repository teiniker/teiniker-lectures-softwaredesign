package org.se.lab;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class EncodingDecorator // package private
	extends LoginServiceDecorator
{
	/*
	 * Constructor Injection
	 */
	public EncodingDecorator(LoginService service)
	{
		super(service);
	}
	
	
	@Override
	public void addUser(int id, String username, String password, String mail)
	{
		super.addUser(id, username, toSHA256(password), mail);
	}

	@Override
	public boolean login(String username, String password)
	{
		return super.login(username, toSHA256(password));
	}
	
	
	/*
	 * Utility methods
	 * (in the case of an exam, these methods will be provided for you!
	 */
	private String toSHA256(String message)
	{
		byte[] bytes;
		try
		{
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");		
			algorithm.update(message.getBytes("UTF-8"));
			bytes = algorithm.digest();
			String hash = convertToHexString(bytes);
			return hash;
		}
		catch (NoSuchAlgorithmException | UnsupportedEncodingException e)
		{
			throw new IllegalStateException(e);
		}
	}

	
	private String convertToHexString(byte[] bytes)
	{
		StringBuilder hex = new StringBuilder();
		for(byte b : bytes)
		{
			int i = (b & 0xff); 
			hex.append(String.format("%02x", i));
		}
		return hex.toString();
	}
}
