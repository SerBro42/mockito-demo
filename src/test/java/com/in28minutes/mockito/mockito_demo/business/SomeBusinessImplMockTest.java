package com.in28minutes.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//This annotation is necessary for mock injections to work. It allows to automate creation and injection.
@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {
	
	//We create a mock for DataService interface
	@Mock
	private DataService dataServiceMock;
	
	//Once DataService mock is created, we inject it into businessImpl
	@InjectMocks
	private SomeBusinessImpl businessImpl;

	@Test
	void Should_ReturnTrue_WhenEqualTo25() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 15, 5});	
		assertEquals(25, businessImpl.findTheGreatestFromAllData());
	}
	
	//Mocking has the advantage over Stubbing that we can write multiple tests without needing to create extra stubs for each one. Consequently, they are simpler to write and easier to maintain.
	@Test
	void Should_ReturnTrue_WhenOneValue() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
		assertEquals(35, businessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void Should_ReturnTrue_WhenEmptyArray() {
		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		//Not the best practice. Since the original class uses Integer.MIN_VALUE, we use it here too.
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}

}
