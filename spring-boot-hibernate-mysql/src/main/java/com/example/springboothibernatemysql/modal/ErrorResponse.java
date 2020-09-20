/**
 * 
 */
package com.example.springboothibernatemysql.modal;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 * @author Mayank
 *
 */
public class ErrorResponse {
	
	private int httpStatusCode;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private Date timeStamp;
	private String message;
	private HttpStatus httpStatus;
	
	public ErrorResponse(int httpStatusCode, String message, HttpStatus httpStatus) {
		super();
		this.timeStamp = new Date();
		this.httpStatusCode = httpStatusCode;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	@Override
	public String toString() {
		return "ErrorResponse [httpStatusCode=" + httpStatusCode + ", timeStamp=" + timeStamp + ", message=" + message
				+ ", httpStatus=" + httpStatus + "]";
	}
		
}
