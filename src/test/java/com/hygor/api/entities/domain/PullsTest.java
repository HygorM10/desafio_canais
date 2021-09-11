package com.hygor.api.entities.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class PullsTest {

	private Pulls pulls = new Pulls();
	
	private User user = new User();
	
	@Test
	public void testPullsConstructor() {
		user.setAvatar_url("www.test.com.br");
		user.setLogin("Test123");
		
		pulls.setBody("test 2");
		pulls.setCreated_at("2021-09-10T01:30");
		pulls.setTitle("test ok");
		pulls.setUser(user);
		
		assertNotNull(pulls);
	}
	
	@Test
	public void testGetPulls() {
		user.setAvatar_url("www.test.com.br");
		user.setLogin("Test123");
		
		pulls.setBody("test 2");
		pulls.setCreated_at("2021-09-10T01:30");
		pulls.setTitle("test ok");
		pulls.setUser(user);
		
		assertEquals(pulls.getBody(), "test 2");
		assertEquals(pulls.getCreated_at(), "2021-09-10T01:30");
		assertEquals(pulls.getTitle(), "test ok");
		assertEquals(pulls.getUser().getAvatar_url(), "www.test.com.br");
		assertEquals(pulls.getUser().getLogin(), "Test123");
	}
}
