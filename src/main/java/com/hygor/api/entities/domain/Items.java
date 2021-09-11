package com.hygor.api.entities.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Items {

	@JsonProperty("items")
	private List<Repositorie> items;
	
}
