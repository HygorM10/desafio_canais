package com.hygor.api.entities.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StashClientException {

	private int code;
	
	private String message;
	
}