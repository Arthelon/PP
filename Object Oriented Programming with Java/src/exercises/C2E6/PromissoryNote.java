package exercises.C2E6;

import java.util.HashMap;

public class PromissoryNote {
	
	private HashMap <String, Double> loans = new HashMap<String, Double>();
	
	public PromissoryNote() {
		
	}
	
	public void setLoan(String toWhom, double value) {
		loans.put(toWhom, value);
	}
	
	public double howMuchIsTheDebt(String whose) {
		if (!loans.containsKey(whose)) return 0;
		return loans.get(whose);
	}
}
