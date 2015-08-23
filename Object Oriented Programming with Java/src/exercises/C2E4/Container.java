package exercises.C2E4;

import java.util.ArrayList;

public class Container {
	private int weightLimit;
	
	private ArrayList<SuitCase> suitcases = new ArrayList<SuitCase>();
	
	public Container(int weightLimit) {
		this.weightLimit = weightLimit;
	}
	
	public void addSuitCase(SuitCase suitcase) {
		if (suitcase.totalWeight() + calcWeight() > weightLimit) {
			
		} else {
			suitcases.add(suitcase);
		}
	}
	
	public String toString() { 
		return suitcases.size() + " suitcases (" + calcWeight() + " kg)";
	}
	
	public int totalWeight() {
		return calcWeight();
	}
	
	public void printThings() {
		for (SuitCase s : suitcases) {
			System.out.println(s);
		}
	}
	
	private int calcWeight() {
		int sum = 0;
		for (SuitCase s : suitcases) {
			sum += s.totalWeight();
		}
		return sum;
	}
}
