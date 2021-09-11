package com.hygor.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hygor.api.entities.domain.Items;
import com.hygor.api.entities.domain.Pulls;
import com.hygor.api.usecase.IPullsGitHub;
import com.hygor.api.usecase.IRepositoriesGitHub;

@Service
public class GitHubServices {

	@Autowired
	private IRepositoriesGitHub iRepositoriesGitHub;

	@Autowired
	private IPullsGitHub iPullsGitHub;

	public Items getRepositories(String q, String sort, Integer page) {

		ResponseEntity<Items> entity = iRepositoriesGitHub.getRepositories(q, sort, page);
		return entity.getBody();
	}

	public List<Pulls> getPulls(String criador, String repositorio) {

		ResponseEntity<List<Pulls>> entity = iPullsGitHub.getPulls(criador, repositorio);
		return entity.getBody();

	}
}
