package com.nagarro.CSVToPDF.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CSVException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public CSVException() {
		super();
	}
	public CSVException(String message) {
		super(message);
	}
	public CSVException(String message, Throwable cause) {
		super(message, cause);
	}	
}
