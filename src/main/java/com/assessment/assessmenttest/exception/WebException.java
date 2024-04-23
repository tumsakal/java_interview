package com.assessment.assessmenttest.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class WebException extends RuntimeException {
	private final HttpStatus status;

	public WebException(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}

	public WebException(HttpStatus status, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
	}

	public int getStatusCode() {
		return this.getStatus().value();
	}
}
