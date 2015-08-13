import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Three_primeFactorCalculator {
	private static ArrayList<Long> list = new ArrayList<Long>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Type a number : ");
		long num = Long.parseLong(scanner.nextLine());
//		long num = 600851475143L;
		
		if (num <= 0) {
			System.out.println("Please input a positive number");
		} else {
			list.add(smallFactor(num));
			num /= smallFactor(num);
			while (num != smallFactor(num)) {
				list.add(smallFactor(num));
				num /= smallFactor(num);
			}
			list.add(smallFactor(num));
			Collections.sort(list);
			System.out.println("Largest Prime Number : "+ list.get(list.size()-1));
		}
		
	}
	public static long smallFactor(long num) {
		for (long i = 2; i < num; i++) {
			if (num%i == 0) {
				return i;
			}
		}
		return num;
	}
}
