package exercises;

import java.util.ArrayList;

public class E63 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(3);
	    list.add(2);
	    list.add(7);
	    list.add(2);

	    System.out.println("First sum: " + sum(list));

	    list.add(10);

	    System.out.println("Second sum: " + sum(list));

	}
	
	public static int sum(ArrayList<Integer> list) {
	   int sum = 0;
	   for (int n : list) {
		   sum += n;
	   }
	   return sum;
	}
}
