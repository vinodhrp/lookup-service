package com.spring.cloud.lookup.util;

import org.springframework.http.HttpStatus;



public class ApiCustomMessage {

	private HttpStatus httpStatus;
	
	private String message;
	
	public ApiCustomMessage() {
		// TODO Auto-generated constructor stub
	}
	
	public ApiCustomMessage(HttpStatus httpStatus,String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
