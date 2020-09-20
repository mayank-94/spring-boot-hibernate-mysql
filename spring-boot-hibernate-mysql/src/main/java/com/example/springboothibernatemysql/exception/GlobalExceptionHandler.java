/**
 * 
 */
package com.example.springboothibernatemysql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.springboothibernatemysql.constants.ConstantsException;
import com.example.springboothibernatemysql.modal.ErrorResponse;

/**
 * @author Mayank
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> internalError(){
		
		ErrorResponse response = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), 
				ConstantsException.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> employeeNotFound(EmployeeNotFoundException e){
		
		ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), 
				e.getMessage(), HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
}
