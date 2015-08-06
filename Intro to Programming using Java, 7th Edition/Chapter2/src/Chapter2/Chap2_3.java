package Chapter2;
import java.util.Scanner;


public class Chap2_3 {
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("What is your name?");
		String name = scanner.nextLine().toUpperCase();
		
		System.out.println("Hello "+name+", nice to meet you!!");
		
	}
}
