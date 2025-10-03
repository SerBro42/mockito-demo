package com.in28minutes.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

	@Test
	void Should_ReturnTrue_WhenEqualTo25() {
		var dataServiceStub = new DataServiceStub();
		var businessImpl = new SomeBusinessImpl(dataServiceStub);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(25, result);
	}
	
	@Test
	void Should_ReturnTrue_WithOneValue() {
		var dataServiceStub = new DataServiceStub1();
		var businessImpl = new SomeBusinessImpl(dataServiceStub);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(35, result);
	}
}

//DataService stub implementation. Each scenario requires its own separate stub.
//Problem with the stub approach #2: testing more than one scenario is difficult with this approach. You'd have to create a separate stub for every single scenario, which reduces maintainability. 
class DataServiceStub implements DataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {25, 15, 5};
	}
}

class DataServiceStub1 implements DataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {35};
	}
}
