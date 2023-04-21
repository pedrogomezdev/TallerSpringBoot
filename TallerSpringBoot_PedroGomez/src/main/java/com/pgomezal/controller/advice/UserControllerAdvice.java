package com.pgomezal.controller.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pgomezal.exceptions.ErrorResponse;
import com.pgomezal.exceptions.UserValidationException;

@ControllerAdvice
public class UserControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {UserValidationException.class})
	protected ResponseEntity<Object> handleConflict(UserValidationException ex, WebRequest request){
		String bodyOfResponse = "Falta el nombre y/o la fecha de nacimiento.";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	
	@ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getClass().getSimpleName(),
                "Unexpected error",
                HttpStatus.BAD_REQUEST.value(),
                "An unexpected error occurred"
        );
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
	
	
	
	
}
