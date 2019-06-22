package com.cg.library.exception;
public class BookException extends Exception{

	String message;
	
	public BookException(String message)
	{
		this.message = message;
	}
	@Override
	public String getMessage()
	{
		return this.message;
	}


}
