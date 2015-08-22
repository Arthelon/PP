package exercises;

import java.util.ArrayList;

public class E67 {
	public static double variance(ArrayList<Integer> list) {
	    double squared = 0;
	    double mean = 0;
	    for (int n : list) {
	    	mean += n;
	    }
	    mean = mean / list.size();
	    for (int n : list) {
	    	squared += Math.pow(n - mean, 2);
	    }
	    
	    return squared / list.size();
	    
	    
	}
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(3);
	    list.add(2);
	    list.add(7);
	    list.add(2);
	    System.out.println("The variance is: " + variance(list));
	}
}
