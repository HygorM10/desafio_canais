package com.hygor.api.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hygor.api.entities.domain.Items;
import com.hygor.api.entities.domain.Pulls;
import com.hygor.api.entities.domain.Repositorie;
import com.hygor.api.usecase.IPullsGitHub;
import com.hygor.api.usecase.IRepositoriesGitHub;

@Service
public class GitHubServices {

	@Autowired
	private IRepositoriesGitHub iRepositoriesGitHub;

	@Autowired
	private IPullsGitHub iPullsGitHub;
	
	private static Logger logger = LoggerFactory.getLogger(GitHubServices.class);

	public List<Repositorie> getRepositories(String q, String sort, Integer page) throws Exception {
		
			logger.info("Iniciando chamada ao metodo de consultar repositorios do GitHub para os filtros: {}, {}, {}", q, sort, page);

			ResponseEntity<Items> entity = iRepositoriesGitHub.getRepositories(q, sort, page);
			
			logger.info("Finalizando chamada de consultar repositorios. StatusCode de retorno: {}", entity.getStatusCode());
			
			return entity.getBody().getItems();
		
	}

	public List<Pulls> getPulls(String criador, String repositorio) throws Exception {
		
		logger.info("Iniciando chamada ao metodo de consultar pulls do GitHub para os filtros: {}, {}", criador, repositorio);

		ResponseEntity<List<Pulls>> entity = iPullsGitHub.getPulls(criador, repositorio);
		
		logger.info("Finalizando chamada de consultar pulls. StatusCode de retorno: {}", entity.getStatusCode());
		
		return entity.getBody();

	}
}
