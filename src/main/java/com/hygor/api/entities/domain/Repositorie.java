package com.hygor.api.entities.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Repositorie {

	  /*Nome do repositório (items.name), 
	  Descrição do Repositório (items.description), 
	  Nome (items.owner.login)/ 
	  Foto do autor (items.owner.avatar_url), 
	  Número de Stars (items.stargazers_count), 
	  Número de Forks (items.forks)*/
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("owner")
	private Owner owner;
	
	@JsonProperty("stargazers_count")
	private Integer stargazers_count;
	
	@JsonProperty("forks")
	private Integer forks;
	
}
