package com.org.Exception;

public class AppException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4133531746849455829L;

	public AppException(String msg){
		super(msg);
	}
	
	public AppException(String msg,Throwable course){
		super(msg,course);
	}
}
