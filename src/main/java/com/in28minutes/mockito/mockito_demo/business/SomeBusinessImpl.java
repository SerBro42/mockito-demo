package com.in28minutes.mockito.mockito_demo.business;

public class SomeBusinessImpl {
	
	private DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int greatestValue = Integer.MIN_VALUE;
		for(int value:data) {
			if(value > greatestValue) {
				greatestValue = value;
			}
		}
		return greatestValue;
	}

}

//This service should be a separate file, but we created it here.
//Problem with the stub approach #1: every time we add a new method, we need to update the dataService stub implementation too.
interface DataService {
	int[] retrieveAllData();
}
