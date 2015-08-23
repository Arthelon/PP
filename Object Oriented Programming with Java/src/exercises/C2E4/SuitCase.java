package exercises.C2E4;

import java.util.ArrayList;

public class SuitCase {
	private int weightLimit;
	private ArrayList<Thing> things = new ArrayList<Thing>();
	
	public SuitCase (int weightLimit) {
		this.weightLimit = weightLimit;
	}
	
	public void addThing(Thing thing) {
		int sum = 0;
		for (Thing t : things) {
			sum += t.getWeight();
		}
		if (sum + thing.getWeight() > weightLimit) {
			
		} else {
			things.add(thing);
		}
	}
	
	public void printThings() {
		for (Thing t : things) {
			System.out.println(t);
		}
	}
	
	public int totalWeight() {
		int sum = 0;
		for (Thing t : things) {
			sum += t.getWeight();
		}
		return sum;
	}
	
	public Thing heaviestThing() {
		Thing thing = things.get(0);
		for (Thing t : things) {
			if (t.getWeight() > thing.getWeight()) {
				thing = t;
			}
		}
		return thing;
	}
	
	public String toString() {
		int sum = 0;
		for (Thing t : things) {
			sum += t.getWeight();
		}
		if (things.size() == 0) return "empty";
		if (things.size() == 1) {
			return things.size() + " thing (" + sum + " kg)";
		}
		return things.size() + " things (" + sum + " kg)";
	}
}
