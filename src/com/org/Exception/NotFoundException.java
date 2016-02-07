package com.org.Exception;

public class NotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5998936688747578959L;

	public NotFoundException(String msg){
		super(msg);
	}
	
	public NotFoundException(String msg,Throwable course){
		super(msg,course);
	}


}
