package com.hygor.api.usecase;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hygor.api.entities.domain.Items;

@Component
@FeignClient(name = "repositoriesService", url = "${url.github}")
public interface IRepositoriesGitHub {

	@GetMapping("${patch.repositories.github}")
	ResponseEntity<Items> getRepositories(@RequestParam("q") String q, @RequestParam("sort") String sort, @RequestParam("page") Integer page);
}
