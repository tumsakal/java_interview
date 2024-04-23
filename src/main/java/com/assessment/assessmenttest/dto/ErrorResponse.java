package com.assessment.assessmenttest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {
	private int statusCode;
	private String message;
	private ZonedDateTime timestamp;
}
