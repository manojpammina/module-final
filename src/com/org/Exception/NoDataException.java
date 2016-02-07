

package com.org.Exception;

public class NoDataException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6861767801681814215L;

	/**
	 * 
	 */


	public NoDataException(String msg){
		super(msg);
	}
	
	public NoDataException(String msg,Throwable course){
		super(msg,course);
	}


}
