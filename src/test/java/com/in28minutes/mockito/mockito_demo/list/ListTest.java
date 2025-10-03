package com.in28minutes.mockito.mockito_demo.list;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ListTest {

	@Test
	void Should_ReturnTrue_WhenListSizeIs3() {
		//We mock the List class
		var listMock = mock(List.class);
		//We set the size of the List as 3
		when(listMock.size()).thenReturn(3);
		assertEquals(3, listMock.size());
		//Once you have the correct return value once, you can call it several times and it still returns true
		assertEquals(3, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(3, listMock.size());

	}
	
	@Test
	void Should_ReturnTrue_WithMultipleReturns() {
		var listMock = mock(List.class);
		//We create two lists, the first one size=1, and the second one, size=2
		when(listMock.size()).thenReturn(1).thenReturn(2);
		assertEquals(1, listMock.size());
		assertEquals(2, listMock.size());
		//The second return value is 2, if you call it several times, it still returns true
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());

	}
	
	@Test
	void Should_ReturnTrue_WithSpecificParameters() {
		var listMock = mock(List.class);
		//We set a String value in the first position of the list.
		when(listMock.get(0)).thenReturn("SomeString");
		assertEquals("SomeString", listMock.get(0));
		//Just for the sake of it, we assert that the second position in the list is null.
		assertEquals(null, listMock.get(1));

	}
	
	@Test
	void Should_ReturnTrue_WithGenericParameters() {
		var listMock = mock(List.class);
		when(listMock.get(Mockito.anyInt())).thenReturn("SomeOtherString");
		assertEquals("SomeOtherString", listMock.get(0));
		assertEquals("SomeOtherString", listMock.get(1));
		assertEquals("SomeOtherString", listMock.get(2));
	}

}
