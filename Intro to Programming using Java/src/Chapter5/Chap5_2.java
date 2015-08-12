package Chapter5;
import java.util.Scanner;


import support.StatCalc;

public class Chap5_2 {
	
	public static void main(String[] args) {
		StatCalc calc = new StatCalc();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please input values : ");
		System.out.println("Input 0 to stop");
		double val = scanner.nextDouble();
		while (val != 0) {
			calc.enter(val);
			val = scanner.nextDouble();
		}
		System.out.println("Dataset statistics : ");
		System.out.println("Max : " + calc.getMax());
		System.out.println("Min : " + calc.getMin());
		System.out.println("Mean : " + calc.getMean());
	}
}