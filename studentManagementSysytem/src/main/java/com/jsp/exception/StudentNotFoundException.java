package com.jsp.exception;

public class StudentNotFoundException extends RuntimeException {
	
	private String message;
	public StudentNotFoundException(String mesage) {
		   super(mesage); 
	        this.message = message; 
	    }

	    @Override
	    public String getMessage() {
	        return message;
	}
}
