package com.hygor.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hygor.api.entities.domain.Items;
import com.hygor.api.entities.domain.Pulls;
import com.hygor.api.services.GitHubServices;

@RestController
@RequestMapping("github/v1")
public class GitHubRepositorieController {

	@Autowired
	private GitHubServices gitHubServices;

	@GetMapping(value = "/repositories")
	public ResponseEntity<Items> getRepositories(@RequestParam("q") String q, @RequestParam("sort") String sort, @RequestParam("page") Integer page) {
		Items body = gitHubServices.getRepositories(q, sort, page);
		return ResponseEntity.ok(body);
	}
	
	@GetMapping(value = "/pulls/{criador}/{repositorio}")
	public ResponseEntity<List<Pulls>> getPulls(@PathVariable("criador") String criador, @PathVariable("repositorio") String repositorio) {
		List<Pulls> body = gitHubServices.getPulls(criador, repositorio);
		return ResponseEntity.ok(body);
	}
}
