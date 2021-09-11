package com.hygor.api.entities.domain.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GitHubException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer code;
	
	private String message;
	
	public GitHubException(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public GitHubException(String message) {
		this.message = message;
	}
	
}
