package com.hcl.Exception;

public class MyException extends RuntimeException{
	
	String message;
	
	public MyException(String msg)
	{
		this.message=msg;
		System.out.println(message);
	}

}
