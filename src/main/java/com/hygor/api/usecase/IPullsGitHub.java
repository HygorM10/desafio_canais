package com.hygor.api.usecase;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hygor.api.entities.domain.Pulls;

@Component
@FeignClient(name = "pullsService", url = "${url.github}")
public interface IPullsGitHub {

	@GetMapping("${patch.repositories.github.pulls}")
	ResponseEntity<List<Pulls>> getPulls(@PathVariable("criador") String criador, @PathVariable("repositorio") String repositorio);
}
