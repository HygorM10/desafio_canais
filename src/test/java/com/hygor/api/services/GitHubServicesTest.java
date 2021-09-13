package com.hygor.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hygor.api.entities.domain.Items;
import com.hygor.api.entities.domain.Owner;
import com.hygor.api.entities.domain.Pulls;
import com.hygor.api.entities.domain.Repositorie;
import com.hygor.api.entities.domain.User;
import com.hygor.api.usecase.IPullsGitHub;
import com.hygor.api.usecase.IRepositoriesGitHub;

@RunWith(MockitoJUnitRunner.class)
public class GitHubServicesTest {

	@InjectMocks
	private GitHubServices gitHubServices;
	
	@Mock
	private IRepositoriesGitHub iRepositoriesGitHub;

	@Mock
	private IPullsGitHub iPullsGitHub;
	
	private Items items = new Items();

	private Repositorie repositorie = new Repositorie();

	private Owner owner = new Owner();

	private Pulls pulls = new Pulls();

	private User user = new User();
	
	List<Repositorie> repositories = new ArrayList<Repositorie>();

	List<Pulls> list = new ArrayList<Pulls>();
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setup() {

		MockitoAnnotations.initMocks(this);
		
		owner.setAvatar_url("www.test.com.br");
		owner.setLogin("test123");

		repositorie.setDescription("Test description");
		repositorie.setForks(123);
		repositorie.setName("Test");
		repositorie.setStargazers_count(123);
		repositorie.setOwner(owner);

		repositories = new ArrayList<Repositorie>();

		repositories.add(repositorie);

		items.setItems(repositories);

		user.setAvatar_url("www.test.com.br");
		user.setLogin("Test123");

		pulls.setBody("test 2");
		pulls.setCreated_at("2021-09-10T01:30");
		pulls.setTitle("test ok");
		pulls.setUser(user);

		list.add(pulls);
	
	}
	
	@Test
	public void testServiceGetRepositories() throws Exception {
		
		when(iRepositoriesGitHub.getRepositories(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt())).thenReturn(new ResponseEntity<Items>(items, HttpStatus.OK));
		
		List<Repositorie> return_service = gitHubServices.getRepositories("a", "d", 1);

		assertEquals(return_service, repositories);
		
	}
	
	@Test
	public void testServiceGetPulls() throws Exception {
		
		when(iPullsGitHub.getPulls(Mockito.anyString(), Mockito.anyString()))
		.thenReturn(new ResponseEntity<List<Pulls>>(list, HttpStatus.OK));
		
		List<Pulls> return_service = gitHubServices.getPulls("a", "d");

		assertEquals(return_service, list);
		
	}
	
}
