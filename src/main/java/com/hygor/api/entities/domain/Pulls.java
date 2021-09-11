package com.hygor.api.entities.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Pulls {

	@JsonProperty("title")
	private String title;
	
	@JsonProperty("created_at")
	private String created_at;
	
	@JsonProperty("body")
	private String body;
	
	@JsonProperty("user")
	private User user;
}
