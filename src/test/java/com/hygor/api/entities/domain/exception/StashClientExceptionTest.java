package com.hygor.api.entities.domain.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StashClientExceptionTest {

	@Test
	public void testStashClientExceptionGetter() {
		
		StashClientException stashClientException = new StashClientException(422, "error test");
		
		assertEquals(422, stashClientException.getCode());
		assertEquals("error test", stashClientException.getMessage());
		
	}
	
	@Test
	public void testStashClientExceptionSetter() {
		
		StashClientException stashClientException = new StashClientException(422, "error test");
		
		stashClientException.setCode(500);
		stashClientException.setMessage("error test override");
		
		assertEquals(500, stashClientException.getCode());
		assertEquals("error test override", stashClientException.getMessage());
		
	}
	
}
