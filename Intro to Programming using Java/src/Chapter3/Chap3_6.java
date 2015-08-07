package Chapter3;

import java.util.ArrayList;

public class Chap3_6 {
	public static void main(String[] args) {
		ArrayList<Integer> num = new ArrayList<Integer>();
		int divNum = 0;
		
		for (int i = 1; i <= 10000; i++) {
			int div = 0;
			for (int i2 = 1; i2 <= i; i2++) {
				if (i % i2 == 0) {
					div++;
				}
			}
			if (div == divNum) {
				num.add(i);
			}
			if (div > divNum) {
				divNum = div;
				num.clear();
				num.add(i);
			}
		}
		System.out.println("Max Number of divisors : " + divNum);
		System.out.println("List of numbers with that many divisors : ");
		for (int i = 0; i < num.size(); i++) {
			System.out.println(""+num.get(i));
		}
		
	}
}
