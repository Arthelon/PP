package exercises;

import java.util.ArrayList;

public class E64 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(3);
	    list.add(2);
	    list.add(7);
	    list.add(2);

	    System.out.println("The average is: " + average(list));
	}
	
	public static double average(ArrayList<Integer> list) {
		int sum = 0;
		for (int n : list) {
			sum += n;
		}
		
		return (double) sum / list.size();
	}
}
