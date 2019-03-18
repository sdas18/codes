package com.cg.payroll.exceptions;
public class AssociateDetailNotfoundException extends Exception 
{ 
     String s;
	public AssociateDetailNotfoundException(String s) {
		this.s=s;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AssociateDetailNotfoundException [s=" + s + "]";
	}
	
/*
	public AssociateDetailNotfoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AssociateDetailNotfoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AssociateDetailNotfoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AssociateDetailNotfoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	*/
}
