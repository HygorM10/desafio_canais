package com.hygor.api.entities.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;



public class ItemsTest {
	
	private Items items = new Items();
	
	private Repositorie repositorie = new Repositorie();
	
	private Owner owner = new Owner();

	@Test
	public void testConstructNoNullItems() {
		
		owner.setAvatar_url("www.test.com.br");
		owner.setLogin("test123");
		
		repositorie.setDescription("Test description");
		repositorie.setForks(123);
		repositorie.setName("Test");
		repositorie.setStargazers_count(123);
		repositorie.setOwner(owner);
		
		List<Repositorie> repositories = new ArrayList<Repositorie>();
		
		repositories.add(repositorie);
		
		items.setItems(repositories);
		
		assertNotNull(repositories);
		
	}
	
	@Test
	public void testGetItems() {
		
		owner.setAvatar_url("www.test.com.br");
		owner.setLogin("test123");
		
		repositorie.setDescription("Test description");
		repositorie.setForks(123);
		repositorie.setName("Test");
		repositorie.setStargazers_count(123);
		repositorie.setOwner(owner);
		
		List<Repositorie> repositories = new ArrayList<Repositorie>();
		
		repositories.add(repositorie);
		
		items.setItems(repositories);
		
		assertEquals(repositories.get(0).getDescription(), "Test description");
		assertEquals(repositories.get(0).getForks(), 123);
		assertEquals(repositories.get(0).getName(), "Test");
		assertEquals(repositories.get(0).getStargazers_count(), 123);
		assertEquals(repositories.get(0).getOwner().getAvatar_url(), "www.test.com.br");
		assertEquals(repositories.get(0).getOwner().getLogin(), "test123");
		assertEquals(items.getItems().get(0).getClass(), Repositorie.class);
		
	}
}
