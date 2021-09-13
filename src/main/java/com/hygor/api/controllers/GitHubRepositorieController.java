package com.hygor.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hygor.api.entities.domain.Pulls;
import com.hygor.api.entities.domain.Repositorie;
import com.hygor.api.entities.domain.exception.StashClientException;
import com.hygor.api.services.GitHubServices;

import feign.FeignException;

@RestController
@RequestMapping("github/v1")
public class GitHubRepositorieController {

	@Autowired
	private GitHubServices gitHubServices;

	private static Logger logger = LoggerFactory.getLogger(GitHubRepositorieController.class);

	@GetMapping(value = "/repositories", produces="application/json")
	public ResponseEntity<Object> getRepositories(@RequestParam("q") String q, @RequestParam("sort") String sort,
			@RequestParam("page") Integer page) {

		try {

			logger.info("Iniciando consulta de repositorios");

			List<Repositorie> body = gitHubServices.getRepositories(q, sort, page);

			logger.info("Finalizando consulta de repositorios");

			return ResponseEntity.ok(body);

		} catch (FeignException ex) {

			logger.error("Erro chamada API GitHub - Consulta Repositorios. Status Code: {}", ex.status());

			HttpStatus status = HttpStatus.resolve(ex.status());

			if (status == null)
				status = HttpStatus.INTERNAL_SERVER_ERROR;

			StashClientException stashClientException = new StashClientException(ex.status(), ex.getMessage());

			logger.error("Enviando erro ao chamador. Message: {} Status Code: {}", ex.getMessage(), status);

			return new ResponseEntity<>(stashClientException, status);

		} catch (Exception e) {
			logger.error("Erro interno consulta API GitHub Repositories");

			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

			StashClientException stashClientException = new StashClientException(status.value(), e.getMessage());

			logger.error("Enviando erro ao chamador. Message: {} Status Code: {}", e.getMessage(), status);

			return new ResponseEntity<>(stashClientException, status);
		}

	}

	@GetMapping(value = "/pulls/{criador}/{repositorio}", produces="application/json")
	public ResponseEntity<Object> getPulls(@PathVariable("criador") String criador,
			@PathVariable("repositorio") String repositorio) {

		try {

			logger.info("Iniciando consulta de pulls");

			List<Pulls> body = gitHubServices.getPulls(criador, repositorio);

			logger.info("Finalizando consulta de pulls");

			return ResponseEntity.ok(body);

		} catch (FeignException ex) {

			logger.error("Erro chamada API GitHub - Consulta Pulls. Status Code: {}", ex.status());

			HttpStatus status = HttpStatus.resolve(ex.status());

			if (status == null)
				status = HttpStatus.INTERNAL_SERVER_ERROR;

			StashClientException stashClientException = new StashClientException(ex.status(), ex.getMessage());

			logger.error("Enviando erro ao chamador. Message: {} Status Code: {}", ex.getMessage(), status);

			return new ResponseEntity<>(stashClientException, status);

		} catch (Exception e) {
			logger.error("Erro interno consulta API GitHub Pulls");

			HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

			StashClientException stashClientException = new StashClientException(status.value(), e.getMessage());

			logger.error("Enviando erro ao chamador. Message: {} Status Code: {}", e.getMessage(), status);

			return new ResponseEntity<>(stashClientException, status);
		}

	}
}
