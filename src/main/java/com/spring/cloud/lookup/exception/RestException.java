package com.spring.cloud.lookup.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.cloud.lookup.util.ApiCustomMessage;

@ControllerAdvice
@Configuration
public class RestException extends ResponseEntityExceptionHandler {
	
	public Logger logger = LoggerFactory.getLogger(RestException.class);

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<?> handleAllExceptions(Exception ex, WebRequest request) {
		logger.error("Common Exception Thrown : ", ex.getMessage());
		
		ApiCustomMessage apiCustomMessage = new ApiCustomMessage(HttpStatus.BAD_REQUEST,
				"Something Went Wrong..." + ex.getMessage());
		return new ResponseEntity<ApiCustomMessage>(apiCustomMessage, HttpStatus.BAD_REQUEST);
	}

}
