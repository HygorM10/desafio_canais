package com.hygor.api.entities.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {

	@JsonProperty("login")
	private String login;
	
	@JsonProperty("avatar_url")
	private String avatar_url;
	
}
