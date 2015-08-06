package Chapter2;
import java.util.Scanner;


public class Chap2_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("How many quarters?");
		int quarters = scanner.nextInt();
		System.out.println("How many nickels?");
		int nickels = scanner.nextInt();
		System.out.println("How many dimes?");
		int dimes = scanner.nextInt();
		System.out.println("How many pennies?");
		int pennies = scanner.nextInt();
		
		double sum = quarters * 0.25 + nickels * 0.05 + dimes * 0.1 + pennies * 0.01;
		
		System.out.printf("%1.2f", sum);
	}
}
