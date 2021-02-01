package com.example.employee.exception;

public class EmployeeNotFoundException extends Exception {
	
	private static final long serialVersionUID = 4273848184577153952L;

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}
	
	public EmployeeNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public EmployeeNotFoundException(Throwable throwable) {
		super(throwable);
	}
	
}
