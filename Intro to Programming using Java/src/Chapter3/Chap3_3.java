package Chapter3;
import textIO.TextIO;

public class Chap3_3 {

	public static void main(String[] args) {
		while (true) {
			System.out.println("Please type in a simple expression");
			double first = TextIO.getDouble();
			char operator = TextIO.getChar();
			double second = TextIO.getDouble();
			
			double product = 0;
			System.out.println(operator);
			if (operator == '*') {
				product = first * second;
			} else if (operator == '/') {
				product = first / second;
			} else if (operator == '+') {
				product = first + second;
			} else if (operator == '-') {
				product = first - second;
			} else {
				System.out.println("Please re-enter expression using 4 basic operators");
				continue;
			}
			
			System.out.println("The result of this expression is : "+product);
			
		}

	}

}
