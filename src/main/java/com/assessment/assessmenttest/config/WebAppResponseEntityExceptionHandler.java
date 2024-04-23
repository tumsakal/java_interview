package com.assessment.assessmenttest.config;

import com.assessment.assessmenttest.dto.ErrorResponse;
import com.assessment.assessmenttest.exception.WebException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@ControllerAdvice
@Slf4j
public class WebAppResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	protected ZonedDateTime getCurrentTime() {
		return ZonedDateTime.now(ZoneOffset.UTC);
	}

	@ExceptionHandler(WebException.class)
	protected ResponseEntity<ErrorResponse> handleWebException(WebException ex) {
		ErrorResponse errorResponse =
			ErrorResponse.builder()
				.timestamp(getCurrentTime())
				.statusCode(ex.getStatusCode())
				.message(ex.getMessage())
				.build();

		log.error("An exception occurred", ex);
		return new ResponseEntity<>(errorResponse, ex.getStatus());
	}
}
