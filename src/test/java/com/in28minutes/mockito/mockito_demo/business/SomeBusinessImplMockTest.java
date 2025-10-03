package com.in28minutes.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class SomeBusinessImplMockTest {

	@Test
	void Should_ReturnTrue_WhenEqualTo25() {
		
		//Initialise the mock
		var dataServiceMock = mock(DataService.class);
		//When the dataServiceMock is called, return these values
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15, 5});
		
		var businessImpl = new SomeBusinessImpl(dataServiceMock);
		assertEquals(25, businessImpl.findTheGreatestFromAllData());
	}
	
	//Mocking has the advantage over Stubbing that we can write multiple tests without needing to create extra stubs for each one. Consequently, they are simpler to write and easier to maintain.
	@Test
	void Should_ReturnTrue_WhenOneValue() {
		
		//Initialise the mock
		var dataServiceMock = mock(DataService.class);
		//When the dataServiceMock is called, return these values
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
		
		var businessImpl = new SomeBusinessImpl(dataServiceMock);
		assertEquals(35, businessImpl.findTheGreatestFromAllData());
	}
	

}
